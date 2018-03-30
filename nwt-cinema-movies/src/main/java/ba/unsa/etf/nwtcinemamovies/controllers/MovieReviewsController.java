package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import ba.unsa.etf.nwtcinemamovies.services.MovieReviewService;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "movieReviews", produces = "application/json")
public class MovieReviewsController extends AbstractController<MovieReviewService> {

	@Transactional
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public void create(@RequestBody @Valid @ModelAttribute("MovieReview") final MovieReview movieReview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return; //TODO
		}
		service.save(movieReview);
	}

	@Transactional
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody @Valid @ModelAttribute("MovieReview") final MovieReview movieReview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "Error";
		}
		return JSONConverter.toJSON(service.update(movieReview));
	}

	@Transactional
	@RequestMapping(value = "{reviewId}", method = RequestMethod.GET)
	public String findById(@PathVariable("reviewId") final Long reviewId) {
		return JSONConverter.toJSON(service.findById(MovieReview.class, reviewId));
	}

	@Transactional
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll() {
		return JSONConverter.toJSON(service.findAll(MovieReview.class));
	}

	@Transactional
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody @Valid @ModelAttribute("MovieReview") final MovieReview movieReview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return; 
		}
		service.delete(movieReview);
	}
}
