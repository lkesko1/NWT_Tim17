package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import ba.unsa.etf.nwtcinemamovies.services.MovieService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "movies", produces = "application/json")
public class MoviesController extends AbstractController<MovieService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody  @Valid @ModelAttribute("Movie") final Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return;
		}
		service.save(movie);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody  @Valid @ModelAttribute("Movie") final Movie movie,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "Error";
		}
		return JSONConverter.toJSON(service.update(movie));
	}

	@Transactional
	@RequestMapping(value = "{movieId}", method = RequestMethod.GET)
	public String findById(@PathVariable("movieId") final Long movieId) {
		return JSONConverter.toJSON(service.findById(Movie.class, movieId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(Movie.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody  @Valid @ModelAttribute("Movie") final Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return;
		}
		service.delete(movie);
	}
}
