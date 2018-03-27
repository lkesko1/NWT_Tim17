package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie extends AbstractModel {

	@Column(name = "imdb_url")
	private String imdbUrl;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}
}
