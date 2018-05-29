package ba.unsa.etf.nwtcinemamovies;

import ba.unsa.etf.nwtcinemamovies.configuration.RMQHandler;
import ba.unsa.etf.nwtcinemamovies.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;


@Component
public class RabbitMQReceiver {
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");

        RMQTransferObject transferObject =
                JSONConverter.fromJSON(
                        new ByteArrayInputStream(message.getBytes()), RMQTransferObject.class);
        try {
            RMQHandler handler = new RMQHandler();
            handler.actionHandler(transferObject);
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
