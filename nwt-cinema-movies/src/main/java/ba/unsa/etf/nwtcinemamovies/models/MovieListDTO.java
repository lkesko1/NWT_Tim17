package ba.unsa.etf.nwtcinemamovies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieListDTO {

    @JsonProperty("Search")
    private List<MovieListObjectDTO> movies;

    public MovieListDTO() {
    }

    public MovieListDTO(List<MovieListObjectDTO> movies) {
        this.movies = movies;
    }

    public List<MovieListObjectDTO> getMovieDTOS() {
        return movies;
    }

    public void setMovies(List<MovieListObjectDTO> movies) {
        this.movies = movies;
    }
}
