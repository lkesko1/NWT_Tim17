package ba.unsa.etf.nwtcinemamovies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieListObjectDTO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private Integer year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Poster")
    private String poster;

    public MovieListObjectDTO() {
    }

    public MovieListObjectDTO(String title, Integer year, String imdbID, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.poster = poster;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
