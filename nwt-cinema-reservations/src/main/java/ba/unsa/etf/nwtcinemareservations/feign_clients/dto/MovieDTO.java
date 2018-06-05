package ba.unsa.etf.nwtcinemareservations.feign_clients.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private Integer year;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Awards")
    private String awards;


    public MovieDTO(String Title, Integer Year, String Genre, String Director, String Actors, String Awards) {
        this.title = Title;
        this.year = Year;
        this.genre = Genre;
        this.director = Director;
        this.actors = Actors;
        this.awards = Awards;
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
}