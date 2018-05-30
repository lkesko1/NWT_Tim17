package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The role repository implementation
 *
 * @author eceric
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleTitle(String t);
}
