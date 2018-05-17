package ba.unsa.etf.nwtcinemaauth.repositories;

import ba.unsa.etf.nwtcinemaauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
