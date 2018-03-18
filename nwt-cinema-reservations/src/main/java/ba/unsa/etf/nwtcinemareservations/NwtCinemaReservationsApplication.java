package ba.unsa.etf.nwtcinemareservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NwtCinemaReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NwtCinemaReservationsApplication.class, args);
	}
}
