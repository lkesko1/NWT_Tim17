package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.Role;
import ba.unsa.etf.nwtcinemamovies.services.RoleService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "nwt_cinema/movies/roles", produces = "application/json")
public class RolesController extends AbstractController<RoleService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody final Role role) {
		service.save(role);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody final Role role) {
		return JSONConverter.toJSON(service.update(role));
	}

	@Transactional
	@RequestMapping(value = "{roleId}", method = RequestMethod.GET)
	public String findById(@PathVariable("roleId") final Integer roleId) {
		return JSONConverter.toJSON(service.findById(Role.class, roleId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(Role.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody final Role role) {
		service.delete(role);
	}
}
