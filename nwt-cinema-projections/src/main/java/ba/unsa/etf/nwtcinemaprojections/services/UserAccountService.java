package ba.unsa.etf.nwtcinemaprojections.services;


import ba.unsa.etf.nwtcinemaprojections.models.UserAccount;
import ba.unsa.etf.nwtcinemaprojections.repositories.IUserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends BaseService<UserAccount, IUserAccountRepository>{
}
