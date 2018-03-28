package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import ba.unsa.etf.nwtcinemamovies.services.MovieReviewService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "movieReviews", produces = "application/json")
public class MovieReviewsController extends AbstractController<MovieReviewService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody final MovieReview movieReview) {
		service.save(movieReview);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody final MovieReview movieReview) {
		return JSONConverter.toJSON(service.update(movieReview));
	}

	@Transactional
	@RequestMapping(value = "{reviewId}", method = RequestMethod.GET)
	public String findById(@PathVariable("reviewId") final Integer reviewId) {
		return JSONConverter.toJSON(service.findById(MovieReview.class, reviewId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(MovieReview.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody final MovieReview movieReview) {
		service.delete(movieReview);
	}
}
