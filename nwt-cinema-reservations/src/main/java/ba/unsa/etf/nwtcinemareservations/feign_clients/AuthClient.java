package ba.unsa.etf.nwtcinemareservations.feign_clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("nwt-cinema-auth")
public interface AuthClient {
}
