package ba.unsa.etf.nwtcinemareservations.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "movie_projection_id")
	private Integer movieProjectionId;

	@Column(name = "number_of_tickets")
	private Integer numberOfTickets;

	@Column(name = "date_created")
	private Date dateCreated;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMovieProjectionId() {
		return movieProjectionId;
	}

	public void setMovieProjectionId(Integer movieProjectionId) {
		this.movieProjectionId = movieProjectionId;
	}

	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
