package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie extends AbstractModel {

	public Movie() {
		super();
	}

	public Movie(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", targetEntity = MovieReview.class,
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MovieReview> movieReviews = new ArrayList<>();

	private String imdbUrl;

	public String getImdbUrl() {
		return imdbUrl;
	}
	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public List<MovieReview> getMovieReviews() {
		return movieReviews;
	}

}
