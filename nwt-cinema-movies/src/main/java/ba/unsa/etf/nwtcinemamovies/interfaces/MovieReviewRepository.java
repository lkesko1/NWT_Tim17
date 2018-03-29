package ba.unsa.etf.nwtcinemamovies.interfaces;

import ba.unsa.etf.nwtcinemamovies.models.MovieReview;

/**
 * The movie review repository
 *
 * @author eceric
 */
public interface MovieReviewRepository<M, I extends Number> extends AbstractRepository<MovieReview, Long> {

}
