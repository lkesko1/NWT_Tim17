package ba.unsa.etf.nwtcinemaprojections.controllers;

import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.services.MovieTimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "movietimetable", produces = "application/json")
public class MovieTimetableController extends BaseController<MovieTimetable, MovieTimetableService> {
}
