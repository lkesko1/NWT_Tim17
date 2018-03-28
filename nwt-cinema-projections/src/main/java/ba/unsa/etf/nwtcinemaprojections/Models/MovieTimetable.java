package ba.unsa.etf.nwtcinemaprojections.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MovieTimetable extends AbstractModel {

	private Integer movieID;

	private Integer createdBy;

	private Date date;

	private Integer maxTickets;

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
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

	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
}
