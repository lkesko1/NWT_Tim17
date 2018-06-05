package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class MovieReview extends AbstractModel {

	@ManyToOne(targetEntity = UserAccount.class)
	private UserAccount userAccount;

	@Min(value = 1, message = "Minimum movie rate is 1.")
	@Max(value = 10, message = "Maximum movie rate is 10.")
	private Integer rate;

	private String comment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
	@NotNull
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

	public MovieReview(UserAccount userAccount, Integer rate, String comment, Movie movie) {
		this.userAccount = userAccount;
		this.rate = rate;
		this.comment = comment;
		this.movie = movie;
	}

	public MovieReview() {
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
