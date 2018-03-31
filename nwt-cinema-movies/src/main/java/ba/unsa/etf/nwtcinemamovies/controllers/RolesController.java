package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.Role;
import ba.unsa.etf.nwtcinemamovies.services.RoleService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "roles", produces = "application/json")
public class RolesController extends AbstractController<RoleService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody final Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(JSONConverter.toJSON("Failed to create role with title " + role.getRoleTitle()));
		}
		return ResponseEntity.ok(service.save(role));
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity update(@RequestBody final Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(JSONConverter.toJSON("Failed to update role with title " + role.getRoleTitle()));
		}
		return ResponseEntity.ok(service.update(role));
	}

	@Transactional
	@RequestMapping(value = "{roleId}", method = RequestMethod.GET)
	public String findById(@PathVariable("roleId") final Long roleId) {
		return JSONConverter.toJSON(service.findById(Role.class, roleId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(Role.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestBody final Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(JSONConverter.toJSON("Failed to delete role with title " + role.getRoleTitle()));
		}
		service.delete(role);
		return ResponseEntity.ok(
				JSONConverter.toJSON("Successfully deleted role with title " + role.getRoleTitle()));
	}
}
