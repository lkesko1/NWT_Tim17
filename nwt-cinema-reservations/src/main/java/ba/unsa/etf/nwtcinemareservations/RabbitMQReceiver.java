package ba.unsa.etf.nwtcinemareservations;


import org.springframework.stereotype.Component;


@Component
public class RabbitMQReceiver {
    public void receiveMessage(Object message) {
        System.out.println("Received <" + message + ">");
    }
}
