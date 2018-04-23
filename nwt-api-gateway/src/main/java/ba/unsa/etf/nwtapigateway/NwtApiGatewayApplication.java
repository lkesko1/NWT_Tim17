package ba.unsa.etf.nwtapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class NwtApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NwtApiGatewayApplication.class, args);
	}
}
