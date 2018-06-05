package ba.unsa.etf.nwtcinemareservations.feign_clients;


import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieProjectionDTO;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.TicketReservationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("nwt-cinema-projections")
public interface MovieProjectionsClient {

    @RequestMapping(method = RequestMethod.GET, value = "movietimetable/{id}")
    MovieProjectionDTO getMovieProjection(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "movietimetable/reserve-tickets")
    ResponseEntity reserveTickets(@RequestBody TicketReservationDTO ticketReservation);

}
