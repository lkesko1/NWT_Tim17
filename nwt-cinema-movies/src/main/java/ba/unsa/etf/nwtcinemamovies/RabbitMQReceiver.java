package ba.unsa.etf.nwtcinemamovies;

import ba.unsa.etf.nwtcinemamovies.configuration.RMQHandler;
import ba.unsa.etf.nwtcinemamovies.dto.RMQTransferObject;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
    public void receiveMessage(Object message) {
        System.out.println("Received <" + message + ">");

        Gson gson = new Gson();
        RMQTransferObject transferObject = gson.fromJson((String)message, RMQTransferObject.class);
        try {
            RMQHandler.actionHandler(transferObject);
        }
        catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}
