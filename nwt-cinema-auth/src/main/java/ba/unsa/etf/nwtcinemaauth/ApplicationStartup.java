package ba.unsa.etf.nwtcinemaauth;

import ba.unsa.etf.nwtcinemaauth.models.NWTCinemaUser;
import ba.unsa.etf.nwtcinemaauth.models.Role;
import ba.unsa.etf.nwtcinemaauth.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {
        Role roleAdmin = roleRepository.save(new Role("ROLE_ADMIN", "Administrator"));
        Role roleUser = roleRepository.save(new Role("ROLE_USER", "User"));

        userRepository.save(new NWTCinemaUser("admin@admin.com", "Admin1", "admin", roleAdmin));
        userRepository.save(new NWTCinemaUser("adnan@adnan.com", "Adnan1", "adnan", roleUser));
        userRepository.save(new NWTCinemaUser("anisa@anisa.com", "Anisa1", "anisa", roleUser));
        userRepository.save(new NWTCinemaUser("edin@edin.com", "Edin1", "edin", roleUser));
        userRepository.save(new NWTCinemaUser("lejla@lejla.com", "Lejla1", "lejla", roleUser));
    }
}

