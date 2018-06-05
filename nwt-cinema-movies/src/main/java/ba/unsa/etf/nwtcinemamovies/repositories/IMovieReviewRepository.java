package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The movie review repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public interface IMovieReviewRepository extends JpaRepository<MovieReview, Long> {

	@Transactional
	List<MovieReview> findByMovie(Long movieId);
}
