package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import ba.unsa.etf.nwtcinemamovies.services.MovieService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
		return ResponseEntity.ok(service.add(movie));
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

	@Transactional
	@RequestMapping(value = "/addMovie/{movieID}", method = RequestMethod.POST)
	public ResponseEntity addMovie(@PathVariable("movieID") final String movieId) {
		try{
		return ResponseEntity.ok(service.addNewMovie(movieId));
		}
		catch (java.io.IOException e)
		{return ResponseEntity.badRequest().body(
				JSONConverter.toJSON("Failed to fetch movie with given id " + movieId));}
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "{movieId}", method = RequestMethod.GET)
	public ResponseEntity findById(@PathVariable("movieId") final Long movieId) {
		try {
			JSONConverter.configure();
			return ResponseEntity.ok(service.findById(movieId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to fetch movie with given id " + movieId));
		}
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "/omdb/{movieId}", method = RequestMethod.GET)
	public ResponseEntity fetchMovieByiMDBId(@PathVariable("movieId") final String movieId) {
		try {
			JSONConverter.configure();
			return ResponseEntity.ok(service.fetchMovieByIMDBId(movieId));
		} catch (java.io.IOException e) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to fetch movie with given id " + movieId));
		}
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "/get-movies/{name}", method = RequestMethod.GET)
	public ResponseEntity fetchByName(@PathVariable("name") final String name) {
		try {
			JSONConverter.configure();
			return ResponseEntity.ok(service.fetchMoviesByName(name));
		} catch (java.io.IOException e) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to fetch movies with given name " + name));
		}
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity findAll() {
		try {
			JSONConverter.configure();
			return ResponseEntity.ok(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(JSONConverter.toJSON("Failed to fetch movies"));
		}
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}



//	@RequestMapping(value = "search", method = RequestMethod.GET)
//	public ResponseEntity search(@RequestParam String title) {
////		this.service.fetchMovieByTitle(title);
////		return 2;
//	}
}
