package ba.unsa.etf.nwtcinemareservations.repositories;

import ba.unsa.etf.nwtcinemareservations.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findUserAccountByUsername(String s);
}
