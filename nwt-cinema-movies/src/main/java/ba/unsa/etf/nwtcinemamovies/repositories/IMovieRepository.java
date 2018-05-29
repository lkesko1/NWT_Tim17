package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The movie repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Long> {

}
