package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie extends AbstractModel {

	@NotNull
	public Movie() {
		super();
	}

	@NotNull
	public Movie(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", targetEntity = MovieReview.class,
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MovieReview> movieReviews = new ArrayList<>();

	@NotNull
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
