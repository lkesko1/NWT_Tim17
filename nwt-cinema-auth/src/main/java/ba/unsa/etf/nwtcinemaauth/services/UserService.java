package ba.unsa.etf.nwtcinemaauth.services;

import ba.unsa.etf.nwtcinemaauth.configuration.Configuration;
import ba.unsa.etf.nwtcinemaauth.dto.CreatedUser;
import ba.unsa.etf.nwtcinemaauth.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemaauth.models.NWTCinemaUser;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import com.netflix.config.WebApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void createUser(NWTCinemaUser nwtCinemaUser) {
        userRepository.save(nwtCinemaUser);
        rabbitTemplate.convertAndSend(
                Configuration.EXCHANGE_KEY,
                Configuration.USER_CREATED_ROUTING_KEY,
                new RMQTransferObject(
                        "nwt-cinema-auth",
                        Configuration.USER_CREATED_ROUTING_KEY,
                        new CreatedUser(nwtCinemaUser.getUsername(), Configuration.ROLE_USER))
        );
    }
}
