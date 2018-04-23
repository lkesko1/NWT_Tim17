package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.interfaces.MovieReviewRepository;
import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * The movie review repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public class MovieReviewRepositoryImpl extends AbstractRepositoryImpl<MovieReview, Long>
		implements MovieReviewRepository<MovieReview, Long> {

}
