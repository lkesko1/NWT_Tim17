package ba.unsa.etf.nwtcinemamovies.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class MovieReview {

	@Id
	@GeneratedValue
	private Integer id;

	@JoinColumn(name = "movie_id")
	private Integer movieId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "rate")
	private Integer rate;

	@Column(name = "comment")
	private String comment;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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
}
