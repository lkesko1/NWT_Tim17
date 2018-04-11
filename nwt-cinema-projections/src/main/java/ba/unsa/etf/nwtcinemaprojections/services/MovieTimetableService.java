package ba.unsa.etf.nwtcinemaprojections.services;

import ba.unsa.etf.nwtcinemaprojections.controllers.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.repositories.IMovieTimetableRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieTimetableService extends BaseService<MovieTimetable, IMovieTimetableRepository>{

    public void reserveTickets(TicketReservationDTO ticketReservation) throws Exception {
        Optional<MovieTimetable> timetable = this.repository.findById(ticketReservation.getProjectionId());
        int newNumberOfTickets = timetable.get().getActualTickets() + ticketReservation.getTickets();
        if (newNumberOfTickets > timetable.get().getMaxTickets()) {
            throw new Exception("No enough room");
        }
        timetable.get().setActualTickets(newNumberOfTickets);
        this.repository.save(timetable.get());
    }


}
