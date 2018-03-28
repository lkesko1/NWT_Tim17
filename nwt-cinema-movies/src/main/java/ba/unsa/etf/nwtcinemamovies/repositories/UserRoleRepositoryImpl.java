package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.interfaces.UserRoleRepository;
import ba.unsa.etf.nwtcinemamovies.models.UserRole;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * The User role repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public class UserRoleRepositoryImpl extends AbstractRepositoryImpl<UserRole, Integer>
		implements UserRoleRepository<UserRole, Integer> {

}
