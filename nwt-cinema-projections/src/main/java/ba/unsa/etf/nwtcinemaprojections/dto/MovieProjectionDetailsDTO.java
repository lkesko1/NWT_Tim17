package ba.unsa.etf.nwtcinemaprojections.dto;

import java.util.Date;

public class MovieProjectionDetailsDTO {
    private Integer actualTickets;
    private Integer maxTickets;
    private Date date;
    private OMDBMovie movie;

    public MovieProjectionDetailsDTO() {
    }

    public MovieProjectionDetailsDTO(Integer actualTickets, Integer maxTickets, Date date, OMDBMovie movie) {
        this.actualTickets = actualTickets;
        this.maxTickets = maxTickets;
        this.date = date;
        this.movie = movie;
    }

    public Integer getActualTickets() {
        return actualTickets;
    }

    public void setActualTickets(Integer actualTickets) {
        this.actualTickets = actualTickets;
    }

    public Integer getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(Integer maxTickets) {
        this.maxTickets = maxTickets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OMDBMovie getMovie() {
        return movie;
    }

    public void setMovie(OMDBMovie movie) {
        this.movie = movie;
    }
}

