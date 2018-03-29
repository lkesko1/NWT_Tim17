package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieReview extends AbstractModel {

	@NotNull(message = "User id must be defined.")
	private Long userId;

	@Size(min = 1, max = 10, message = "Movie rating must be between 1 and 10")
	private Integer rate;

	private String comment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
	@NotNull
	private Movie movie;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public MovieReview(Long userId, Integer rate, String comment, Movie movie) {
		this.userId = userId;
		this.rate = rate;
		this.comment = comment;
		this.movie = movie;
	}

	public MovieReview() {
	}

}
