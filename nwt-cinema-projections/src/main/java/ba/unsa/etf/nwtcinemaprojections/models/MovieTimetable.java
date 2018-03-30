package ba.unsa.etf.nwtcinemaprojections.models;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class MovieTimetable extends AbstractModel {

	@NotNull
	@Min(1)
	private Long movieID;

	@NotNull
	@Min(1)
	private Long createdBy;

	@NotNull
	@Past
	private Date date;

	@NotNull
	@Min(0)
	@Max(40)
	private Integer maxTickets;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getMaxTickets() {
		return maxTickets;
	}

	public void setMaxTickets(Integer maxTickets) {
		this.maxTickets = maxTickets;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public MovieTimetable() {
	}

	public MovieTimetable(Long movieID, Long createdBy, Date date, Integer maxTickets) {
		this.movieID = movieID;
		this.createdBy = createdBy;
		this.date = date;
		this.maxTickets = maxTickets;
	}
}
