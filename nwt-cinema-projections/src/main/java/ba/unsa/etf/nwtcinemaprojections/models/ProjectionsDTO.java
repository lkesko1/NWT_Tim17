package ba.unsa.etf.nwtcinemaprojections.models;

import java.util.Date;

public class ProjectionsDTO {

    private Long projectionID;

    private Long movieID;

    private Long createdBy;

    private Date date;

    private Integer actualTickets;

    private Integer maxTickets;

    private String title;

    private String genre;

    public ProjectionsDTO() {
    }

    public ProjectionsDTO(Long projectionID, Long movieID, Long createdBy, Date date, Integer actualTickets, Integer maxTickets, String title, String genre) {
        this.projectionID = projectionID;
        this.movieID = movieID;
        this.createdBy = createdBy;
        this.date = date;
        this.actualTickets = actualTickets;
        this.maxTickets = maxTickets;
        this.title = title;
        this.genre = genre;
    }

    public Long getProjectionID() {
        return projectionID;
    }

    public void setProjectionID(Long projectionID) {
        this.projectionID = projectionID;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
