package ba.unsa.etf.nwtcinemaprojections.feign_clients.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

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

    @JsonProperty("Ratings")
    private List<Rating> ratings;

    public MovieDTO(String Title, Integer Year, String Genre, String Director, String Actors, String Awards,
                    List<Rating> Ratings) {
        this.title = Title;
        this.year = Year;
        this.genre = Genre;
        this.director = Director;
        this.actors = Actors;
        this.awards = Awards;
        this.ratings = Ratings;
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
}

