package ba.unsa.etf.nwtcinemaprojections.feign_clients.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.URL;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private Long id;

//    private List<MovieReview> movieReviews = new ArrayList<>();

    private String imdbUrl;

    public MovieDTO() {
    }

    public MovieDTO(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

//    public List<MovieReview> getMovieReviews() {
//        return movieReviews;
//    }
public Long getId() {
    return id;
}
}
