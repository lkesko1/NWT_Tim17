package ba.unsa.etf.nwtcinemaprojections.repositories;

import ba.unsa.etf.nwtcinemaprojections.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findUserAccountByUsername(String s);
}
