package ba.unsa.etf.nwtcinemareservations;


import ba.unsa.etf.nwtcinemareservations.configuration.RMQHandler;
import ba.unsa.etf.nwtcinemareservations.dto.RMQTransferObject;
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
