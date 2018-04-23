package ba.unsa.etf.nwtcinemaupcomings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NwtCinemaUpcomingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NwtCinemaUpcomingsApplication.class, args);
	}
}
