package ba.unsa.etf.nwtcinemamovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan
public class NwtCinemaMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NwtCinemaMoviesApplication.class, args);
	}
}
