package ba.unsa.etf.nwtcinemamovies.configuration;

import ba.unsa.etf.nwtcinemamovies.dto.CreatedUser;
import ba.unsa.etf.nwtcinemamovies.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemamovies.models.UserAccount;
import ba.unsa.etf.nwtcinemamovies.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemamovies.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class RMQHandler {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private IRoleRepository roleRepository;

    public void actionHandler(RMQTransferObject transferObject) {
        switch (transferObject.getRoutingKey()) {
            case "users.created": // move to a const variable
                CreatedUser createdUser = (CreatedUser)transferObject.getPayload();
                userAccountService.add(new UserAccount(
                        roleRepository.findRoleByRoleTitle(createdUser.getRoleTitle()), createdUser.getUsername()
                ));
                break;
            default:
                break;


        }
    }
}
