package ba.unsa.etf.nwtcinemareservations.feign_clients.dto;

import java.util.Date;

public class MovieProjectionDTO {

    private Long movieID;

    private Long createdBy;

    private Date date;

    private Integer actualTickets;

    private Integer maxTickets;

    public MovieProjectionDTO() {
    }

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

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

    public MovieProjectionDTO(Long movieID, Long createdBy, Date date, Integer actualTickets, Integer maxTickets) {
        this.movieID = movieID;
        this.createdBy = createdBy;
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
