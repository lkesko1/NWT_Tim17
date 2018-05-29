package ba.unsa.etf.nwtcinemamovies.services;

import ba.unsa.etf.nwtcinemamovies.models.UserAccount;
import ba.unsa.etf.nwtcinemamovies.repositories.IUserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends BaseService<UserAccount, IUserAccountRepository> {

}
