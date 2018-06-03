package ba.unsa.etf.nwtcinemaauth.services;

import ba.unsa.etf.nwtcinemaauth.configuration.Configuration;
import ba.unsa.etf.nwtcinemaauth.dto.CreatedUser;
import ba.unsa.etf.nwtcinemaauth.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemaauth.models.NWTCinemaUser;
import ba.unsa.etf.nwtcinemaauth.models.Role;
import ba.unsa.etf.nwtcinemaauth.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import ba.unsa.etf.nwtcinemaauth.utils.JSONConverter;
import com.google.gson.Gson;
import com.netflix.config.WebApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void createUser(NWTCinemaUser nwtCinemaUser, Boolean admin) {
        Role role = null;
        if (admin) {
            role = roleRepository.findRoleByRoleTitle("ROLE_ADMIN");
        }
        else {
            role = roleRepository.findRoleByRoleTitle("ROLE_USER");
        }
        nwtCinemaUser.setRole(role);
        userRepository.save(nwtCinemaUser);
        // Notify other microservices
        Gson gson = new Gson();
        rabbitTemplate.convertAndSend(
                Configuration.EXCHANGE_KEY,
                Configuration.USER_CREATED_ROUTING_KEY,
                gson.toJson(new RMQTransferObject(
                        "nwt-cinema-auth",
                        Configuration.USER_CREATED_ROUTING_KEY,
                        gson.toJson(new CreatedUser(nwtCinemaUser.getUsername(), role.getRoleTitle()))))
        );
    }
}
