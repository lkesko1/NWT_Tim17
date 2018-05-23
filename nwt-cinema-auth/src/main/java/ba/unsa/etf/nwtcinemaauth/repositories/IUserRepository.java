package ba.unsa.etf.nwtcinemaauth.repositories;

import ba.unsa.etf.nwtcinemaauth.models.NWTCinemaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<NWTCinemaUser, Long> {
    NWTCinemaUser findUserByUsername(String username);
}
