package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.Role;
import ba.unsa.etf.nwtcinemamovies.services.RoleService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "nwt_cinema/movies/roles", produces = "application/json")
public class RolesController extends AbstractController<RoleService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody @Valid @ModelAttribute("Role") final Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return;
		}
		service.save(role);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody @Valid @ModelAttribute("Role") final Role role, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				return "Error";
			}
		return JSONConverter.toJSON(service.update(role));
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
	public void delete(@RequestBody @Valid @ModelAttribute("Role") final Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ;
		}
		service.delete(role);
	}
}
