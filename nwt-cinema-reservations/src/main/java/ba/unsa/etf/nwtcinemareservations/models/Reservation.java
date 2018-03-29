package ba.unsa.etf.nwtcinemareservations.models;

import javax.persistence.Entity;
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

	public Reservation(Long userId, Long movieProjectionId, Integer numberOfTickets, Date dateCreated) {
		this.userId = userId;
		this.movieProjectionId = movieProjectionId;
		this.numberOfTickets = numberOfTickets;
		this.dateCreated = dateCreated;
	}
}
