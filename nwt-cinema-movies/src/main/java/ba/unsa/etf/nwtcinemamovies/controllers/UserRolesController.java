package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.UserRole;
import ba.unsa.etf.nwtcinemamovies.services.UserRoleService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "userRoles", produces = "application/json")
public class UserRolesController extends AbstractController<UserRoleService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody @Valid @ModelAttribute("UserRole") final UserRole role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return;
		}
		service.save(role);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody @Valid @ModelAttribute("UserRole") final UserRole role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "Error";
		}
		return JSONConverter.toJSON(service.update(role));
	}

	@Transactional
	@RequestMapping(value = "{roleId}", method = RequestMethod.GET)
	public String findById(@PathVariable("roleId") final Long roleId) {
		return JSONConverter.toJSON(service.findById(UserRole.class, roleId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(UserRole.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody @Valid @ModelAttribute("UserRole") final UserRole role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ;
		}
		service.delete(role);
	}
}
