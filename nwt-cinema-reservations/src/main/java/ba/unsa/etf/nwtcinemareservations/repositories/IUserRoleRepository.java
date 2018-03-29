package ba.unsa.etf.nwtcinemareservations.repositories;

import ba.unsa.etf.nwtcinemareservations.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
}
