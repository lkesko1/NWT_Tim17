package ba.unsa.etf.nwtcinemamovies.interfaces;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import java.io.Serializable;

/**
 * The abstract repository interface containing basic CRUD methods
 *
 * @param <T>  generic return type
 * @param <ID> generic id type
 *
 * Implemented by {@link AbstractRepository}
 *
 * @author eceric
 */
@NoRepositoryBean
public interface AbstractRepository<T, ID extends Serializable> extends Repository<T, ID> {

	/**
	 * Saves new entity
	 *
	 * @param entity to be created
	 */
	void save(T entity);

	/**
	 * Updates entity
	 *
	 * @param entity to be updated
	 * @return updated entity
	 */
	<S extends T> S update(T entity);

	/**
	 * Finds entity
	 *
	 * @param id by witch the entity will be found
	 * @return found entity
	 */
	<S extends T> S findById(Class<T> clazz, ID id);

	/**
	 * Finds all entities
	 *
	 * @return entities
	 */
	Iterable<T> findAll(Class<T> clazz);

	/**
	 * Deletes entity
	 *
	 * @param entity to be deleted
	 */
	void delete(T entity);
}
