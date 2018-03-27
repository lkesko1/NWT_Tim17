package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.UserRole;
import ba.unsa.etf.nwtcinemamovies.services.UserRoleService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "userRoles", produces = "application/json")
public class UserRoles extends AbstractController<UserRoleService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody final UserRole role) {
		service.save(role);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody final UserRole role) {
		return JSONConverter.toJSON(service.update(role));
	}

	@Transactional
	@RequestMapping(value = "{roleId}", method = RequestMethod.GET)
	public String findById(@PathVariable("roleId") final Integer roleId) {
		return JSONConverter.toJSON(service.findById(UserRole.class, roleId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(UserRole.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody final UserRole role) {
		service.delete(role);
	}
}
