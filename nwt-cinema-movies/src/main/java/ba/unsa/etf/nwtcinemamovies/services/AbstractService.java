package ba.unsa.etf.nwtcinemamovies.services;

import ba.unsa.etf.nwtcinemamovies.models.AbstractModel;
import ba.unsa.etf.nwtcinemamovies.interfaces.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Abstract service
 *
 * @param <AR> the Repository Type
 * @author eceric
 */
public abstract class AbstractService<AR extends AbstractRepository> {

	/**
	 * The Repository
	 */
	protected AR repository;

	/**
	 * Sets repository.
	 *
	 * @param repository the repository
	 */
	@Autowired
	public void setRepository(AR repository) {
		this.repository = repository;
	}

	/**
	 * Saves new entity
	 *
	 * @param entity to be created
	 * @return created entity
	 */
	public <T extends AbstractModel> void save(T entity) {
		repository.save(entity);
	}

	/**
	 * Updates entity
	 *
	 * @param entity to be updated
	 * @return updated entity
	 */
	public <T extends AbstractModel> T  update(T entity) {
		return (T) repository.update(entity);
	}

	/**
	 * Finds entity
	 *
	 * @param id by witch the entity will be found
	 * @return found entity
	 */
	public <T extends AbstractModel> T findById(Class<T> clazz, Integer id) {
		return (T) repository.findById(clazz, id);
	}

	/**
	 * Finds all entities
	 *
	 * @return entities
	 */
	public <T extends AbstractModel> Iterable<T> findAll(Class<T> clazz) {
		return repository.findAll(clazz);
	}

	/**
	 * Deletes entity
	 *
	 * @param entity to be deleted
	 */
	public <T extends AbstractModel> void delete(T entity) {
		repository.delete(entity);
	}
}
