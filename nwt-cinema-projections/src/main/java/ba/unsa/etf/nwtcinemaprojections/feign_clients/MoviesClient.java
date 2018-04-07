package ba.unsa.etf.nwtcinemaprojections.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("nwt-cinema-movies")
public interface MoviesClient {
}
