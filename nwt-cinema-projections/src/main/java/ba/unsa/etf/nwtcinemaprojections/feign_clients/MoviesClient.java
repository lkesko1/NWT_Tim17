package ba.unsa.etf.nwtcinemaprojections.feign_clients;

import ba.unsa.etf.nwtcinemaprojections.dto.MovieProjectionDTO;
import ba.unsa.etf.nwtcinemaprojections.feign_clients.dto.MovieDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("nwt-cinema-movies")
public interface MoviesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/movies/movies/{id}")
    MovieDTO getMovie(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/projections/add-projection")
    ResponseEntity addProjection(@RequestBody MovieProjectionDTO movieProjection);

    @RequestMapping(method = RequestMethod.GET, value = "movies/movies/{id}")
    MovieDTO getMovieDetails(@PathVariable("id") Long id);


}
