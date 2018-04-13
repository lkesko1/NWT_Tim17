package ba.unsa.etf.nwtcinemaprojections.services;

import ba.unsa.etf.nwtcinemaprojections.controllers.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemaprojections.feign_clients.MoviesClient;
import ba.unsa.etf.nwtcinemaprojections.feign_clients.dto.MovieDTO;
import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.repositories.IMovieTimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieTimetableService extends BaseService<MovieTimetable, IMovieTimetableRepository>{

    @Autowired
    private MoviesClient moviesClient;

    public void reserveTickets(TicketReservationDTO ticketReservation) throws Exception {
        Optional<MovieTimetable> timetable = this.repository.findById(ticketReservation.getProjectionId());
        int newNumberOfTickets = timetable.get().getActualTickets() + ticketReservation.getTickets();
        if (newNumberOfTickets > timetable.get().getMaxTickets()) {
            throw new Exception("No enough room");
        }
        timetable.get().setActualTickets(newNumberOfTickets);
        this.repository.save(timetable.get());
    }

    public MovieDTO getDetails(Long movieId){
        return moviesClient.getMovieDetails(movieId);

    }


}
