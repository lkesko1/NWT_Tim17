package ba.unsa.etf.nwtcinemaauth;

import ba.unsa.etf.nwtcinemaauth.models.Role;
import ba.unsa.etf.nwtcinemaauth.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private static final String IMDB_URL = "http://www.imdb.com/title/tt0172495/";
    private static final Long DUMMY_UID = 100000L;
    private static final Integer RATE = 10;
    private static final String MOVIE_COMMENT = "Gladiator is awesome!!!";

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {
        roleRepository.save(new Role("ROLE_ADMIN", "Administrator"));
        roleRepository.save(new Role("ROLE_USER", "User"));
    }

}

