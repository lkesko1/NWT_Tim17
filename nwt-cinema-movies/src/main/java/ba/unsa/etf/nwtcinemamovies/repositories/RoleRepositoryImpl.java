package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.interfaces.RoleRepository;
import ba.unsa.etf.nwtcinemamovies.models.Role;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * The role repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public class RoleRepositoryImpl extends AbstractRepositoryImpl<Role, Long>
		implements RoleRepository<Role, Long>{

}
