package ba.unsa.etf.nwtcinemaprojections.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MovieTimetable extends AbstractModel {

	private Long movieID;

	private Long createdBy;

	private Date date;

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
