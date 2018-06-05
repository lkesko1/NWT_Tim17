package ba.unsa.etf.nwtcinemareservations.models;

import java.util.Date;

public class ReservationDTO {


    private Long reservationId;

    private Long projectionId;

    private Long movieId;

    private Long userId;

    private String movieName;

    private Integer numberOfTickets;

    private Date dateCreated;


    public ReservationDTO() {
    }

    public ReservationDTO(Long reservationId, Long projectionId, Long movieId, Long userId, String movieName, Integer numberOfTickets, Date dateCreated) {
        this.reservationId = reservationId;
        this.projectionId = projectionId;
        this.movieId = movieId;
        this.userId = userId;
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.dateCreated = dateCreated;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
}
