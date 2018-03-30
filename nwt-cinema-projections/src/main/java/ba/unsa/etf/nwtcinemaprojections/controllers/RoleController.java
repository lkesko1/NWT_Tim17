package ba.unsa.etf.nwtcinemaprojections.controllers;

import ba.unsa.etf.nwtcinemaprojections.models.Role;
import ba.unsa.etf.nwtcinemaprojections.services.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "roles", produces = "application/json")
public class RoleController extends BaseController<Role, RoleService> {
}
