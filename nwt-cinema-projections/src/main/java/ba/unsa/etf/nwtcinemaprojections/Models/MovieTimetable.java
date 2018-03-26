package ba.unsa.etf.nwtcinemaprojections.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MovieTimetable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "createdBy")
	private Integer createdBy;

	@Column(name = "date")
	private Date date;

	@Column(name = "max_tickets")
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
}
