package ba.unsa.etf.nwtcinemareservations.configuration;

import ba.unsa.etf.nwtcinemareservations.dto.CreatedUser;
import ba.unsa.etf.nwtcinemareservations.dto.RMQTransferObject;
import ba.unsa.etf.nwtcinemareservations.models.UserAccount;
import ba.unsa.etf.nwtcinemareservations.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemareservations.services.UserAccountService;
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
