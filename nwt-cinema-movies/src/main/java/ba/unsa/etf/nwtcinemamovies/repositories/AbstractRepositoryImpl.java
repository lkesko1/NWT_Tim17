package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.interfaces.AbstractRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * The abstract repository interface implementation containing basic CRUD methods
 *
 * @param <T>  generic return type
 * @param <ID> generic id type
 *
 * @author eceric
 */
public abstract class AbstractRepositoryImpl<T, ID extends Serializable> implements AbstractRepository<T, ID> {

	private static final String ENTITY_ID = "id";

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	/**
	 * Saves new entity
	 *
	 * @param entity to be created
	 */
	@Override
	@Transactional
	public T save(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	/**
	 * Updates entity
	 *
	 * @param entity to be updated
	 * @return updated entity
	 */
	@Override
	@Transactional
	public <S extends T> S update(T entity) {
		return (S) getEntityManager().merge(entity);
	}

	/**
	 * Finds entity
	 *
	 * @param id by witch the entity will be found
	 * @return found entity
	 */
	@Override
	@Transactional
	public <S extends T> S findById(Class<T> clazz, ID id) {
		return (S) getBaseCriteria(clazz).add(Restrictions.eq(ENTITY_ID, id)).uniqueResult();
	}

	/**
	 * Finds all entities
	 *
	 * @return entities
	 */
	@Override
	@Transactional
	public Iterable<T> findAll(Class<T> clazz) {
		return (Iterable<T>) getBaseCriteria(clazz).list();
	}

	/**
	 * Deletes entity
	 *
	 * @param entity to be deleted
	 */
	@Override
	@Transactional
	public void delete(T entity) {
		//TO DO: Find out why context gets lost and entity detaches
		getEntityManager().remove(getEntityManager().contains(entity) ? entity : getEntityManager().merge(entity));
	}

	/**
	 * Creates base criteria for fetching entities
	 *
	 * @param clazz class for which the criteria will be built
	 * @return criteria for fetching entities
	 */
	protected Criteria getBaseCriteria(Class<T> clazz) {
		return getEntityManager().unwrap(Session.class).createCriteria(clazz);
	}

	/**
	 * Getter method for the entity manager
	 *
	 * @return entity manager
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
