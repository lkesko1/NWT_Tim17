package ba.unsa.etf.nwtcinemaprojections.configuration;

import ba.unsa.etf.nwtcinemaprojections.dto.CreatedUser;
import ba.unsa.etf.nwtcinemaprojections.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemaprojections.models.Role;
import ba.unsa.etf.nwtcinemaprojections.models.UserAccount;
import ba.unsa.etf.nwtcinemaprojections.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemaprojections.services.UserAccountService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("Duplicates")
@Component
public class RMQHandler {

    private static UserAccountService userAccountService;

    private static IRoleRepository roleRepository;

    @Autowired
    public RMQHandler(UserAccountService userAccountService, IRoleRepository roleRepository) {
        RMQHandler.userAccountService = userAccountService;
        RMQHandler.roleRepository = roleRepository;
    }

    public static void actionHandler(RMQTransferObject transferObject) {
        Gson gson = new Gson();
        switch (transferObject.getRoutingKey()) {
            case "users.created": // move to a const variable
                CreatedUser createdUser = gson.fromJson(transferObject.getPayload(), CreatedUser.class);
                Role role = roleRepository.findRoleByRoleTitle(createdUser.getRoleTitle());
                userAccountService.add(new UserAccount(role, createdUser.getUsername()));
                break;
            default:
                break;
        }
    }
}
