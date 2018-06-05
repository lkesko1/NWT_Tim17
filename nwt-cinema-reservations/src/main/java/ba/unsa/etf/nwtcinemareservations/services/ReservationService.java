package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.configuration.RabbitMQConfiguration;
import ba.unsa.etf.nwtcinemareservations.feign_clients.MovieProjectionsClient;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieProjectionDTO;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.repositories.IReservationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}

