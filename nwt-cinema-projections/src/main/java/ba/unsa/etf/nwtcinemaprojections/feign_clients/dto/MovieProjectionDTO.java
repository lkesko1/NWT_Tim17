package ba.unsa.etf.nwtcinemaprojections.feign_clients.dto;

import java.util.Date;

public class MovieProjectionDTO {
    private Long movieID;
    private Date date;
    private Integer maxTickets;

    private Integer actualTickets;

    public MovieProjectionDTO() {
    }

    public MovieProjectionDTO(Long movieID, Date date, Integer actualTickets, Integer maxTickets) {
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
    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
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


}
