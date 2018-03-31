package ba.unsa.etf.nwtcinemareservations;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("")
    }
}
