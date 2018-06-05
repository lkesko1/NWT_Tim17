package ba.unsa.etf.nwtcinemamovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private String comment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
	@NotNull
	@JsonIgnore
	private Movie movie;

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

	public MovieReview(UserAccount userAccount, String comment, Movie movie) {
		this.userAccount = userAccount;
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
