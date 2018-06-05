package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.feign_clients.MovieProjectionsClient;
import ba.unsa.etf.nwtcinemareservations.feign_clients.MoviesClient;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieDTO;
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
    private MoviesClient moviesClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Reservation add(Reservation reservation) {

        MovieProjectionDTO movieProjectionDTO;
        try {
            movieProjectionDTO = movieProjectionsClient.getMovieProjection(reservation.getMovieProjectionId());

            if (movieProjectionDTO.getActualTickets() + reservation.getNumberOfTickets() > movieProjectionDTO.getMaxTickets()) {
                throw new Exception("There is no enough seats available!1");
            }
            ResponseEntity response = movieProjectionsClient.reserveTickets(new TicketReservationDTO(
                movieProjectionDTO.getId(), reservation.getNumberOfTickets()
            ));
            if (response.getStatusCode() != HttpStatus.CREATED) {
                throw new Exception("There is no enough seats available!2");
            }
            reservation.setDateCreated(new Date());

            return super.add(reservation);
        }
        catch (Exception exception) {
            System.out.println("ADD RESERVATION Exception: ===> " + exception.getMessage());
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

    public List<Reservation> getReservationsByUserID(Long userID){
        List<Reservation> all = repository.findAll();

        List<Reservation> returnReservations = new ArrayList<>();

        for(Reservation res : all){
            if(res.getUserAccount().getId().equals(userID))
                returnReservations.add(res);

        }
        return returnReservations;
    }

    public List<ReservationDTO> getReservationsByUserIDwDetails(Long userID){
        List<Reservation> reservations = getReservationsByUserID(userID);
        List<ReservationDTO> usersReservation = new ArrayList<>();

        for(Reservation res : reservations) {
            MovieProjectionDTO movieProjectionDTO = movieProjectionsClient.getMovieProjection(res.getMovieProjectionId());
            System.out.println(movieProjectionDTO.toString());
            MovieDTO movieDTO = moviesClient.getMovieDetails(movieProjectionDTO.getMovieID());
            if (movieDTO != null) {
                System.out.println(movieDTO.toString());
                ReservationDTO reservation = new ReservationDTO(res.getId(), res.getMovieProjectionId(),
                        movieDTO.getId(),
                        res.getUserAccount().getId(), movieDTO.getTitle(), res.getNumberOfTickets(), res.getDateCreated());

                usersReservation.add(reservation);
            }
        }

        return usersReservation;
    }
}

