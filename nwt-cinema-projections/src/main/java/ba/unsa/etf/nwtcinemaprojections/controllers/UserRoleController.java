package ba.unsa.etf.nwtcinemaprojections.controllers;

import ba.unsa.etf.nwtcinemaprojections.models.UserRole;
import ba.unsa.etf.nwtcinemaprojections.services.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user-roles", produces = "application/json")
public class UserRoleController extends BaseController<UserRole, UserRoleService> {
}