package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The abstract model
 */
@MappedSuperclass
public abstract class AbstractModel {

	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
