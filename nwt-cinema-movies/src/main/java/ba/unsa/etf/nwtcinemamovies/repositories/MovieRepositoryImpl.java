package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.interfaces.MovieRepository;
import ba.unsa.etf.nwtcinemamovies.models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The movie repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public class MovieRepositoryImpl extends AbstractRepositoryImpl<Movie, Long>
		implements MovieRepository<Movie, Long> {

}
