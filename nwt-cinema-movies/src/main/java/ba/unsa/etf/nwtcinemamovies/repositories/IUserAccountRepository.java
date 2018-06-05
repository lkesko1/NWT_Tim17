package ba.unsa.etf.nwtcinemamovies.repositories;

import ba.unsa.etf.nwtcinemamovies.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * The User role repository implementation
 *
 * @author eceric
 */
@Repository
@Transactional
public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findUserAccountByUsername(String s);
}
