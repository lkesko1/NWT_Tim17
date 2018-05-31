package ba.unsa.etf.nwtcinemareservations.controllers;

import ba.unsa.etf.nwtcinemareservations.models.UserAccount;
import ba.unsa.etf.nwtcinemareservations.services.UserAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user-roles", produces = "application/json")
public class UserRoleController extends BaseController<UserAccount, UserAccountService> {
}
