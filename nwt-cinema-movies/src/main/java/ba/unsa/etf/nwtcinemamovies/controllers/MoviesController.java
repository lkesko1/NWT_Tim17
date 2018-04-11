package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import ba.unsa.etf.nwtcinemamovies.services.MovieService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "movies", produces = "application/json")
public class MoviesController extends AbstractController<MovieService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody final Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(JSONConverter.toJSON("Failed to create movie with url " + movie.getImdbUrl()));
		}
		return ResponseEntity.ok(service.save(movie));
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity update(@RequestBody final Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to update movie with url " + movie.getImdbUrl()));
		}
		return ResponseEntity.ok(service.update(movie));
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "{movieId}", method = RequestMethod.GET)
	public ResponseEntity findById(@PathVariable("movieId") final Long movieId) {
		try {
			JSONConverter.configure();
			return ResponseEntity.ok(service.fetchMovie(movieId));
		} catch (java.io.IOException e) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to fetch movie with given id " + movieId));
		}
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity findAll() {
		try {
			JSONConverter.configure();
			return ResponseEntity.ok(service.fetchAll());
		} catch (ExecutionException | InterruptedException e) {
			return ResponseEntity.badRequest().body(JSONConverter.toJSON("Failed to fetch movies"));
		}
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestBody final Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to delete movie with url " + movie.getImdbUrl()));
		}
		service.delete(movie);
		return ResponseEntity.ok(
				JSONConverter.toJSON("Successfully deleted movie with url " + movie.getImdbUrl()));
	}
}
