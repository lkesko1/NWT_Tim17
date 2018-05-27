package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.models.UserAccount;
import ba.unsa.etf.nwtcinemareservations.repositories.IUserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends BaseService<UserAccount, IUserAccountRepository> {
}
