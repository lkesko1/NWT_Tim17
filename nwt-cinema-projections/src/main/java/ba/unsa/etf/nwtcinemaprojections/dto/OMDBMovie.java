package ba.unsa.etf.nwtcinemaprojections.dto;

import java.util.List;

public class OMDBMovie {

    private class Rating {
        private String source;
        private String value;
    }

    private String id;
    private String title;
    private Integer year;
    private String genre;
    private String director;
    private String actors;
    private String awards;
    private List<Rating> ratings;
}
