package ba.unsa.etf.nwtcinemamovies;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import ba.unsa.etf.nwtcinemamovies.models.Role;
import ba.unsa.etf.nwtcinemamovies.models.UserAccount;
import ba.unsa.etf.nwtcinemamovies.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemamovies.repositories.IUserAccountRepository;
import ba.unsa.etf.nwtcinemamovies.services.MovieReviewService;
import ba.unsa.etf.nwtcinemamovies.services.MovieService;
import ba.unsa.etf.nwtcinemamovies.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private static final String IMDB_URL = "http://www.imdb.com/title/tt0172495/";
	private static final Long DUMMY_UID = 100000L;
	private static final Integer RATE = 10;
	private static final String MOVIE_COMMENT = "Gladiator is awesome!!!";

	/**
	 * This event is executed as late as conceivably possible to indicate that
	 * the application is ready to service requests.
	 */

	private MovieService movieService;
	private IUserAccountRepository userAccountRepository;
	private MovieReviewService movieReviewService;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	@Autowired
	public void setUserAccountService(IUserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}

	@Autowired
	public void setMovieReviewService(MovieReviewService movieReviewService) {
		this.movieReviewService = movieReviewService;
	}

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		seedData();
	}

	@SuppressWarnings("Duplicates")
	private void seedUsers() {
		final Role roleAdmin = roleRepository.save(new Role(RoleService.ROLE_ADMIN, RoleService.ROLE_DESCRIPTION_ADMIN));
		final Role roleUser = roleRepository.save(new Role (RoleService.ROLE_USER, RoleService.ROLE_DESCRIPTION_USER));

		userAccountRepository.save(new UserAccount(roleAdmin, "admin"));
		userAccountRepository.save(new UserAccount(roleUser, "adnan"));
		userAccountRepository.save(new UserAccount(roleUser, "anisa"));
		userAccountRepository.save(new UserAccount(roleUser, "edin"));
		userAccountRepository.save(new UserAccount(roleUser, "lejla"));
	}

	private void seedData() {

		this.seedUsers();

		final Movie movie = movieService.add(new Movie(IMDB_URL, "Gladiator"));
		movieReviewService.add(new MovieReview(DUMMY_UID, RATE, MOVIE_COMMENT, movie));
		//seed some more movies for testing purposes
		movieService.add(new Movie("http://www.imdb.com/title/tt2527336/", "Star Wars: The Last Jedi"));
		movieService.add(new Movie("http://www.imdb.com/title/tt3501632/", "Thor: Ragnarok"));
		movieService.add(new Movie("http://www.imdb.com/title/tt2250912/", "Spider-Man Homecoming"));
	}
}
