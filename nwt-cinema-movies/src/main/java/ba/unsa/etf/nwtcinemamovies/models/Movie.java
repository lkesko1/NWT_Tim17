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

	public Movie( @URL(message = "The URL provided is not valid.") @NotNull(message = "Movie URL must be provided.") String imdbUrl, String title, Integer year, String genre, String director, String actors, String awards) {
		this.imdbUrl = imdbUrl;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.awards = awards;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Movie(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public Movie(String imdbUrl, String name) {
		this.imdbUrl = imdbUrl;
		this.title = name;
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
