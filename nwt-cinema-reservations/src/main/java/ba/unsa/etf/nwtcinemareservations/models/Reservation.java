package ba.unsa.etf.nwtcinemareservations.models;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class Reservation extends AbstractModel{

	@NotNull
	@Min(1)
	private Long userId;

	@NotNull
	@Min(1)
	private Long movieProjectionId;

	@NotNull
	@Min(1)
	@Max(10)
	private Integer numberOfTickets;

	@NotNull
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
