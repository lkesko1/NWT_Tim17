package ba.unsa.etf.nwtcinemaauth.services;

import ba.unsa.etf.nwtcinemaauth.models.NWTCinemaUser;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void createUser(NWTCinemaUser NWTCinemaUser) {
        userRepository.save(NWTCinemaUser);
        //tODO notify other services...
    }
}
