package ba.unsa.etf.nwtcinemaprojections.controllers;

import ba.unsa.etf.nwtcinemaprojections.controllers.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemaprojections.feign_clients.dto.MovieDTO;
import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.services.MovieTimetableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/get-details/{movieId}", method = RequestMethod.GET)
    public MovieDTO getMovieDetails(@PathVariable("movieId") Long movieId){
        return service.getDetails(movieId);
    }

    @RequestMapping(value = "actuals", method = RequestMethod.GET)
    public ResponseEntity actuals() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.getActualProjections());
    }

}
