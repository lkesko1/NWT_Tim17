package ba.unsa.etf.nwtcinemareservations.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation extends AbstractModel{

	private Long userId;

	private Long movieProjectionId;

	private Integer numberOfTickets;

	private Date dateCreated;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieProjectionId() {
		return movieProjectionId;
	}

	public void setMovieProjectionId(Long movieProjectionId) {
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

	public Reservation() {
	}
}
