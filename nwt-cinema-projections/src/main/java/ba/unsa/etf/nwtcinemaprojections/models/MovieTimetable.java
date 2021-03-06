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
	private Date date;

	@NotNull
	@Min(0)
	@Max(1000)
	private Integer actualTickets;

	@NotNull
	@Min(0)
	@Max(1000)
	private Integer maxTickets;

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

	public MovieTimetable(Long movieID, Date date, Integer actualTickets, Integer maxTickets) {
		this.movieID = movieID;
		this.date = date;
		this.actualTickets = actualTickets;
		this.maxTickets = maxTickets;
	}

	public Integer getActualTickets() {
		return actualTickets;
	}

	public void setActualTickets(Integer actualTickets) {
		this.actualTickets = actualTickets;
	}
}
