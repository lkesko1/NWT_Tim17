package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Entity;

@Entity
public class Movie extends AbstractModel {

	public Movie() {
		super();
	}

	public Movie(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	private String imdbUrl;

	public String getImdbUrl() {
		return imdbUrl;
	}
	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}
}
