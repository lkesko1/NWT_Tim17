package ba.unsa.etf.nwtcinemaprojections;


import ba.unsa.etf.nwtcinemaprojections.configuration.RMQHandler;
import ba.unsa.etf.nwtcinemaprojections.dto.RMQTransferObject;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RabbitMQReceiver {
    public void receiveMessage(RMQTransferObject message) {
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
