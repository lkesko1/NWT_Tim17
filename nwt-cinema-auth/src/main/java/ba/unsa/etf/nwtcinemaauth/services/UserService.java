package ba.unsa.etf.nwtcinemaauth.services;

import ba.unsa.etf.nwtcinemaauth.models.User;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void createUser(@Valid User user) {
        userRepository.save(user);
        //tODO notify other services...
    }
}
