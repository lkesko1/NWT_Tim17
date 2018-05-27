package ba.unsa.etf.nwtcinemaprojections.configuration;

import ba.unsa.etf.nwtcinemaprojections.dto.CreatedUser;
import ba.unsa.etf.nwtcinemaprojections.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemaprojections.models.UserAccount;
import ba.unsa.etf.nwtcinemaprojections.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemaprojections.services.UserAccountService;
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
