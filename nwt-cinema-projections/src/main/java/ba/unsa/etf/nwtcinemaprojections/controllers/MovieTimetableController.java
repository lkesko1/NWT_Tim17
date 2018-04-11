package ba.unsa.etf.nwtcinemaprojections.controllers;

import ba.unsa.etf.nwtcinemaprojections.controllers.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.services.MovieTimetableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "movietimetable", produces = "application/json")
public class MovieTimetableController extends BaseController<MovieTimetable, MovieTimetableService> {

    @RequestMapping(value = "reserve-tickets", method = RequestMethod.POST)
    public ResponseEntity reserveTickets(@RequestBody TicketReservationDTO ticketReservation) {
        try {
            this.service.reserveTickets(ticketReservation);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
