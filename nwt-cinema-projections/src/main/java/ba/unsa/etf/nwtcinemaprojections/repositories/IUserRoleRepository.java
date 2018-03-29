package ba.unsa.etf.nwtcinemaprojections.repositories;

import ba.unsa.etf.nwtcinemaprojections.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
}
