package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.UserRole;
import ba.unsa.etf.nwtcinemamovies.services.UserRoleService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "userRoles", produces = "application/json")
public class UserRolesController extends AbstractController<UserRoleService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody final UserRole role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to create user-role relation for role with title "
							+ role.getRole().getRoleTitle()));
		}
		return ResponseEntity.ok(service.save(role));
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity update(@RequestBody UserRole role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to update user-role relation for role with title "
							+ role.getRole().getRoleTitle()));
		}
		return ResponseEntity.ok(service.update(role));
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "{roleId}", method = RequestMethod.GET)
	public String findById(@PathVariable("roleId") final Long roleId) {
		return JSONConverter.toJSON(service.findById(UserRole.class, roleId));
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(UserRole.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestBody final UserRole role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body("Failed to delete user-role relation for role with title " + role.getRole().getRoleTitle());
		}
		service.delete(role);
		return ResponseEntity.ok(JSONConverter.toJSON("Successfully deleted user-role relation with role title "
				+ role.getRole().getRoleTitle()));
	}
}
