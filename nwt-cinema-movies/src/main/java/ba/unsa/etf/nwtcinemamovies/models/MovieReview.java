package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieReview extends AbstractModel {

	@JoinColumn(name = "movie_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Integer movieId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "rate")
	private Integer rate;

	@Column(name = "comment")
	private String comment;

	@Id
	@GeneratedValue
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

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
