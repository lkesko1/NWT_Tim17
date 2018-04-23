package ba.unsa.etf.nwtcinemamovies;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import ba.unsa.etf.nwtcinemamovies.models.Role;
import ba.unsa.etf.nwtcinemamovies.models.UserRole;
import ba.unsa.etf.nwtcinemamovies.services.MovieReviewService;
import ba.unsa.etf.nwtcinemamovies.services.MovieService;
import ba.unsa.etf.nwtcinemamovies.services.RoleService;
import ba.unsa.etf.nwtcinemamovies.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private static final String ROLE_TITLE = "Administrator";
	private static final String ROLE_DESCRIPTION = "Administrator";
	private static final String IMDB_URL = "http://www.imdb.com/title/tt0172495/";
	private static final Long DUMMY_UID = 100000L;
	private static final Integer RATE = 10;
	private static final String MOVIE_COMMENT = "Gladiator is awesome!!!";

	/**
	 * This event is executed as late as conceivably possible to indicate that
	 * the application is ready to service requests.
	 */

	private MovieService movieService;
	private RoleService roleService;
	private UserRoleService userRoleService;
	private MovieReviewService movieReviewService;

	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	@Autowired
	public void setMovieReviewService(MovieReviewService movieReviewService) {
		this.movieReviewService = movieReviewService;
	}

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		seedData();
	}

	private void seedData() {
		final Movie movie = movieService.save(new Movie(IMDB_URL));
		final Role role = roleService.save(new Role(ROLE_TITLE, ROLE_DESCRIPTION));
		userRoleService.save(new UserRole(role, DUMMY_UID));
		movieReviewService.save(new MovieReview(DUMMY_UID, RATE, MOVIE_COMMENT, movie));

		//seed some more movies for testing purposes
		movieService.save(new Movie("http://www.imdb.com/title/tt2527336/"));
		movieService.save(new Movie("http://www.imdb.com/title/tt3501632/"));
		movieService.save(new Movie("http://www.imdb.com/title/tt2250912/"));
	}

}
