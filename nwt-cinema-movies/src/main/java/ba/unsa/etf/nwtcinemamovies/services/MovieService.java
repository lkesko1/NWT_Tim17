package ba.unsa.etf.nwtcinemamovies.services;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import ba.unsa.etf.nwtcinemamovies.models.MovieDTO;
import ba.unsa.etf.nwtcinemamovies.repositories.MovieRepositoryImpl;
import ba.unsa.etf.nwtcinemamovies.utils.JSONConverter;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class MovieService extends AbstractService<MovieRepositoryImpl> {

	private static final String OMDB_API_KEY = "2d5ee0b5";
	private static final String BASE_URL = "http://www.omdbapi.com/?apikey=";

	private HttpClient client = HttpClientBuilder.create().build();

	/**
	 * Fetches IMDB url from database, and than makes API call (GET) to OMDB api
	 *
	 * @param movieId ID of the movie
	 * @return {@link MovieDTO} the movie data transfer object
	 * @throws IOException in case reading of the stream fails
	 */
	public MovieDTO fetchMovie(Long movieId) throws IOException {
		Movie movie = findById(Movie.class, movieId);
		return fetch(formUrl(movie));
	}

	/**
	 * Fetches all movies by making a series of async calls to OMDB api
	 *
	 * @return A list of {@link MovieDTO} movie dtos
	 * @throws ExecutionException in case a thread execution fails
	 * @throws InterruptedException in case a thread execution fails
	 */
	public List<MovieDTO> fetchAll() throws ExecutionException, InterruptedException {
		Collection<Callable<MovieDTO>> callables = new ArrayList<>();
		Iterable<Movie> movies = findAll(Movie.class);
		for (Movie movie : movies) {
			callables.add(() -> fetch(formUrl(movie)));
		}
		return fetchAsync(callables);
	}

	/**
	 * Sends http get to OMDB api
	 *
	 * @param url url
	 * @return the {@link MovieDTO}
	 * @throws IOException in case get fails
	 */
	private MovieDTO fetch(String url) throws IOException {
		HttpResponse response = client.execute(new HttpGet(url));
		return readResponse(response);
	}

	/**
	 * Fetches multiple movies asynchronously via futures
	 *
	 * @param callables list of constructed callables (get requests)
	 * @return list of {@link MovieDTO}
	 * @throws ExecutionException in case one or more threads fail
	 * @throws InterruptedException in case one or more threads fail
	 */
	private List<MovieDTO> fetchAsync(Collection<Callable<MovieDTO>> callables)
			throws ExecutionException, InterruptedException {

		List<Future<MovieDTO>> futures = Executors.newCachedThreadPool().invokeAll(callables);
		List<MovieDTO> movieDTOS = new ArrayList<>();
		for (Future future : futures) {
			movieDTOS.add((MovieDTO) future.get());
		}
		return movieDTOS;
	}

	/**
	 * Parses reponse status and body
	 *
	 * @param response the {@link HttpResponse}
	 * @return a {@link MovieDTO}
	 * @throws IOException in case reading response body fails
	 */
	private MovieDTO readResponse(HttpResponse response) throws IOException {
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return JSONConverter.fromJSON(response.getEntity().getContent(), MovieDTO.class);
		}
		return null;
	}

	/**
	 * Forms url as string based on BASE_URL, OMDB_API_KEY and valid IMDB movie id
	 *
	 * @param movie the {@link Movie} object
	 * @return url as string
	 */
	private String formUrl(Movie movie) {
		String[] movieUrlSplit = movie.getImdbUrl().split("/");
		StringBuilder sb = new StringBuilder(BASE_URL)
				.append(OMDB_API_KEY)
				.append("&i=")
				.append(movieUrlSplit[movieUrlSplit.length - 1]);

		return sb.toString();
	}
}
