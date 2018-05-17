package ba.unsa.etf.nwtcinemaauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class NwtCinemaAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(NwtCinemaAuthApplication.class, args);
	}
}
