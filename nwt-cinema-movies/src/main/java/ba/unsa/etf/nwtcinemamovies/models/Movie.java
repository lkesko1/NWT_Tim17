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

	private String name;
	private String title;
	private Integer year;
	private String genre;
	private String director;
	private String actors;
	private String awards;
	private List<Rating> ratings;

	public Movie(List<MovieReview> movieReviews, @URL(message = "The URL provided is not valid.") @NotNull(message = "Movie URL must be provided.") String imdbUrl, String name, String title, Integer year, String genre, String director, String actors, String awards, List<Rating> ratings) {
		this.movieReviews = movieReviews;
		this.imdbUrl = imdbUrl;
		this.name = name;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.awards = awards;
		this.ratings = ratings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}


	private class Rating {
		private String source;
		private String value;
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


	public Movie() {
		super();
	}


}
