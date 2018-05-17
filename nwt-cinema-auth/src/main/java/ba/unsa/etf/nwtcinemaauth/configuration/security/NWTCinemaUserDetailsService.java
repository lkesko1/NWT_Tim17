package ba.unsa.etf.nwtcinemaauth.configuration.security;

import ba.unsa.etf.nwtcinemaauth.models.User;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class NWTCinemaUserDetailsService implements UserDetailsService {

    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAccount = userRepository.findUserByUsername(username);
        if(userAccount == null) {
            throw new UsernameNotFoundException("User not found");
        }
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return org.springframework.security.core.userdetails.User.withUsername(userAccount.getUsername())
                .password(encoder.encode(userAccount.getPassword()))
                .authorities(Collections.emptyList())
                .build();
    }
}
