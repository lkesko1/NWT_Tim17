package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import ba.unsa.etf.nwtcinemamovies.services.MovieReviewService;
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
@RequestMapping(value = "movieReviews", produces = "application/json")
public class MovieReviewsController extends AbstractController<MovieReviewService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody final MovieReview movieReview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to create movie review for movie "
							+ movieReview.getMovie().getImdbUrl()));
		}
		return ResponseEntity.ok(service.add(movieReview));
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity update(@RequestBody final MovieReview movieReview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(
					JSONConverter.toJSON("Failed to update movie review for movie "
							+ movieReview.getMovie().getImdbUrl()));
		}
		return ResponseEntity.ok(service.update(movieReview));
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "{reviewId}", method = RequestMethod.GET)
	public String findById(@PathVariable("reviewId") final Long reviewId) {
		return JSONConverter.toJSON(service.findById(reviewId));
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll());
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "{movieId}", method = RequestMethod.GET)
	public String findByMovie(@PathVariable("movieId") final Long movieId) {
		return JSONConverter.toJSON(service.findByMovie(movieId));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestBody final MovieReview movieReview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body("Failed to delete movie review for movie " + movieReview.getMovie().getImdbUrl());
		}
		service.delete(movieReview);
		return ResponseEntity.ok("Successfully deleted movie review with url " + movieReview.getMovie().getImdbUrl());
	}
}
