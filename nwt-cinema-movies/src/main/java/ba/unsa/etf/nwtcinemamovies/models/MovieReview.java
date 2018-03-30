package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class MovieReview extends AbstractModel {

	@NotNull
	@Min(1)
	private Long userId;

	@NotNull
	@Min(1)
	@Max(10)
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
