package ba.unsa.etf.nwtcinemamovies.interfaces;

import ba.unsa.etf.nwtcinemamovies.models.Movie;

/**
 * The Movie repository
 *
 * @author eceric
 */
public interface MovieRepository<M, I extends Number> extends AbstractRepository<Movie, Integer> {

}
