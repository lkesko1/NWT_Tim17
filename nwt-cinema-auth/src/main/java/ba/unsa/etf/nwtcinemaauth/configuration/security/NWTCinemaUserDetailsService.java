package ba.unsa.etf.nwtcinemaauth.configuration.security;

import ba.unsa.etf.nwtcinemaauth.models.NWTCinemaUser;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class NWTCinemaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NWTCinemaUser NWTCinemaUserAccount = userRepository.findUserByUsername(username);
        if(NWTCinemaUserAccount == null) {
            throw new UsernameNotFoundException("NWTCinemaUser not found");
        }
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return org.springframework.security.core.userdetails.User.withUsername(NWTCinemaUserAccount.getUsername())
                .password(encoder.encode(NWTCinemaUserAccount.getPassword()))
                .authorities(Collections.emptyList())
                .build();
    }
}
