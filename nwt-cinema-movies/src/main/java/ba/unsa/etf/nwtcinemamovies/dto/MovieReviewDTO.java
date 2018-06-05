package ba.unsa.etf.nwtcinemamovies.dto;

public class MovieReviewDTO {

    private String comment;
    private Long movieId;


    public MovieReviewDTO() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
