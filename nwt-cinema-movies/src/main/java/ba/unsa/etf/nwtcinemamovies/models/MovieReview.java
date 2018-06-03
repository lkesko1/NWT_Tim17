package ba.unsa.etf.nwtcinemamovies.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class MovieReview extends AbstractModel {

	@JsonProperty
	@Column(name = "user_id")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = UserAccount.class)
	private UserAccount user;

	@Min(value = 1, message = "Minimum movie rate is 1.")
	@Max(value = 10, message = "Maximum movie rate is 10.")
	private Integer rate;

	private String comment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
	@NotNull
	@JsonIgnore
	private Movie movie;

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

	public MovieReview(UserAccount user, Integer rate, String comment, Movie movie) {
		this.user = user;
		this.rate = rate;
		this.comment = comment;
		this.movie = movie;
	}

	public MovieReview() {
	}
	
	@JsonGetter
	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}
}
