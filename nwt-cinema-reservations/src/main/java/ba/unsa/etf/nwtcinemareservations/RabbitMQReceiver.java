package ba.unsa.etf.nwtcinemareservations;


import ba.unsa.etf.nwtcinemareservations.configuration.RMQHandler;
import ba.unsa.etf.nwtcinemareservations.dto.RMQTransferObject;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQReceiver {
    public void receiveMessage(Object message) {
        System.out.println("Received <" + message + ">");

        RMQTransferObject transferObject = (RMQTransferObject)(message);
        try {
            RMQHandler handler = new RMQHandler();
            handler.actionHandler(transferObject);
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
