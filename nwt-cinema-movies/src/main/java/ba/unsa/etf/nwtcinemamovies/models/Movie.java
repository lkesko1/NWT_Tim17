package ba.unsa.etf.nwtcinemamovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.URL;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie extends AbstractModel {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", targetEntity = MovieReview.class,
			cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<MovieReview> movieReviews = new ArrayList<>();

	@URL(message = "The URL provided is not valid.")
	@NotNull(message = "Movie URL must be provided.")
	private String imdbUrl;

	public Movie() {
		super();
	}

	public Movie(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

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
