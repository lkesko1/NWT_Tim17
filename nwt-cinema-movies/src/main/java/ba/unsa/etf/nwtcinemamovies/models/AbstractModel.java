package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The abstract model
 */
public abstract class AbstractModel {

	@Id
	@GeneratedValue
	protected Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
