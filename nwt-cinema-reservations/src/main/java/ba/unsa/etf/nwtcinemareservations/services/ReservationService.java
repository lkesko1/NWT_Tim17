package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.feign_clients.MovieProjectionsClient;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieProjectionDTO;
import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.repositories.IReservationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        }
        catch (Exception exception) {
            movieProjectionDTO = null;
        }

        if (movieProjectionDTO.getActualTickets() + reservation.getNumberOfTickets() > movieProjectionDTO.getMaxTickets()) {
            // throw exception: not enough room
        }

        boolean ticketsReserved = false;
        try {
            movieProjectionsClient.reserveTickets(reservation.getNumberOfTickets());
            ticketsReserved = true;
        }
        catch (Exception exception) {

        }

        reservation.setDateCreated(new Date());
        return super.add(reservation);

        // notify all
    }
}

