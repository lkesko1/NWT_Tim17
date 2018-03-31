package ba.unsa.etf.nwtcinemareservations.feign_clients;


import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieProjectionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(serviceId = "nwt-cinema-projections", value = "/movietimetable/")
public interface MovieProjectionsClient {

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    MovieProjectionDTO getMovieProjection(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "reserve-tickets")
    void reserveTickets(@RequestBody int numberOfTickets);

}
