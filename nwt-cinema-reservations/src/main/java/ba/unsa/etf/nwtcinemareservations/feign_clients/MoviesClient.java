package ba.unsa.etf.nwtcinemareservations.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ba.unsa.etf.nwtcinemareservations.feign_clients.dto.MovieDTO;

@Component
@FeignClient("nwt-cinema-movies")
public interface MoviesClient {

    @RequestMapping(method = RequestMethod.GET, value = "movies/movies/{id}")
    MovieDTO getMovieDetails(@PathVariable("id") Long id);
}
