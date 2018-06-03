package ba.unsa.etf.nwtcinemamovies.services;

import ba.unsa.etf.nwtcinemamovies.models.MovieReview;
import ba.unsa.etf.nwtcinemamovies.repositories.IMovieReviewRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MovieReviewService extends BaseService<MovieReview, IMovieReviewRepository> {

	@PersistenceContext
	EntityManager manager;

	public List<MovieReview> findByMovie(Long movieId) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(MovieReview.class);
		return criteria.add(Restrictions.eq("movie.id", movieId)).list();
	}

}
