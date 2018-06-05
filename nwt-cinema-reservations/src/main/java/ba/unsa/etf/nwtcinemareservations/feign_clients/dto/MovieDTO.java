package ba.unsa.etf.nwtcinemareservations.feign_clients.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("director")
    private String director;

    @JsonProperty("actors")
    private String actors;

    @JsonProperty("awards")
    private String awards;


    public MovieDTO(String title, Integer year, String genre, String director, String actors, String awards) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.awards = awards;
    }

    public MovieDTO() {
        //Default public CTOR
    }

    public String getTitle() {
        return title;
    }

    @JsonSetter
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    @JsonSetter
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    @JsonSetter
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    @JsonSetter
    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    @JsonSetter
    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getAwards() {
        return awards;
    }

    @JsonSetter
    public void setAwards(String awards) {
        this.awards = awards;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
}