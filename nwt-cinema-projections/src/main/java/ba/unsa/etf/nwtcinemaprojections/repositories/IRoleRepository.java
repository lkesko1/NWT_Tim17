package ba.unsa.etf.nwtcinemaprojections.repositories;

import ba.unsa.etf.nwtcinemaprojections.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
