package ba.unsa.etf.nwtcinemareservations.repositories;

import ba.unsa.etf.nwtcinemareservations.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleTitle(String t);
}
