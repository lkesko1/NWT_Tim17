package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.configuration.RabbitMQConfiguration;
import ba.unsa.etf.nwtcinemareservations.feign_clients.MovieProjectionsClient;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieProjectionDTO;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.models.ReservationDTO;
import ba.unsa.etf.nwtcinemareservations.repositories.IReservationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService extends BaseService<Reservation, IReservationRepository> {

    @Autowired
    private MovieProjectionsClient movieProjectionsClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Reservation add(Reservation reservation) {

        MovieProjectionDTO movieProjectionDTO;
        try {
            movieProjectionDTO = movieProjectionsClient.getMovieProjection(reservation.getMovieProjectionId());

            if (movieProjectionDTO.getActualTickets() + reservation.getNumberOfTickets() > movieProjectionDTO.getMaxTickets()) {
                throw new Exception("There is no enough seats available!");
            }
            ResponseEntity response = movieProjectionsClient.reserveTickets(new TicketReservationDTO(
                movieProjectionDTO.getId(), reservation.getNumberOfTickets()
            ));
            if (response.getStatusCode() != HttpStatus.CREATED) {
                throw new Exception("There is no enough seats available!");
            }
            reservation.setDateCreated(new Date());

            rabbitTemplate.convertAndSend(
                    RabbitMQConfiguration.NWT_CINEMA_EXCHANGE,
                    "reservations.created",
                    String.format("reservations=%s", reservation.getNumberOfTickets()));
            return super.add(reservation);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public Iterable<Reservation> getReservationsByProjectionID(Long movieProjectionID){
        List<Reservation> all = repository.findAll();

        List<Reservation> returnReservations = new ArrayList<>();

        for(Reservation res : all){
            if(res.getMovieProjectionId() == movieProjectionID)
                returnReservations.add(res);

        }

        return returnReservations;

    }

    public Iterable<Reservation> getReservationsByUserID(Long userID){
        List<Reservation> all = repository.findAll();

        List<Reservation> returnReservations = new ArrayList<>();

        for(Reservation res : all){
            if(res.getUserId() == userID)
                returnReservations.add(res);

        }
        return returnReservations;
    }

//    public Iterable<ReservationDTO> getReservationsByUserIDwDetails(Long userID){
//        List<Reservation> reservations = getReservationsByUserID(userID);
//
//        for(Reservation res : reservations) {
//            movieProjectionsClient.getMovieProjection(res.getMovieProjectionId());
//
//        }
//    }
}

