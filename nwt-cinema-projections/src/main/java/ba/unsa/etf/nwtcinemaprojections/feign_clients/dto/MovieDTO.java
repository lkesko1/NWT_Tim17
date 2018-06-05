package ba.unsa.etf.nwtcinemaprojections.feign_clients.dto;

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

    private static class Rating {

        @JsonProperty("Source")
        private String source;

        @JsonProperty("Value")
        private String value;

        public Rating(String source, String value) {
            this.source = source;
            this.value = value;
        }

        public Rating() {
            //Default empty CTOR
        }

        public String getSource() {
            return source;
        }

        @JsonSetter
        public void setSource(String source) {
            this.source = source;
        }

        public String getValue() {
            return value;
        }

        @JsonSetter
        public void setValue(String value) {
            this.value = value;
        }
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

    @JsonProperty("ratings")
    private List<Rating> ratings;

    public MovieDTO(String title, Integer year, String genre, String director, String actors, String awards,
                    List<Rating> ratings) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.awards = awards;
        this.ratings = ratings;
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

    public List<Rating> getRatings() {
        return ratings;
    }

    @JsonSetter
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Long getId() {
        return id;
    }
}