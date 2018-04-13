package ba.unsa.etf.nwtcinemaprojections.feign_clients;

import ba.unsa.etf.nwtcinemaprojections.feign_clients.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("nwt-cinema-movies")
public interface MoviesClient {

    @RequestMapping(method = RequestMethod.GET, value = "movies/movies/{id}")
    MovieDTO getMovieDetails(@PathVariable("id") Long id);


}
