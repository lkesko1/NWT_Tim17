package ba.unsa.etf.nwtcinemaprojections;

import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.models.Role;
import ba.unsa.etf.nwtcinemaprojections.models.UserAccount;
import ba.unsa.etf.nwtcinemaprojections.repositories.IMovieTimetableRepository;
import ba.unsa.etf.nwtcinemaprojections.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemaprojections.repositories.IUserAccountRepository;
import ba.unsa.etf.nwtcinemaprojections.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Autowired
    private IMovieTimetableRepository movieTimetableRepository;

    @Autowired
    private IRoleRepository roleRepository ;

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    @SuppressWarnings("Duplicates")
    private void seedUsers() {
        final Role roleAdmin = roleRepository.save(new Role(RoleService.ROLE_ADMIN, RoleService.ROLE_DESCRIPTION_ADMIN));
        final Role roleUser = roleRepository.save(new Role (RoleService.ROLE_USER, RoleService.ROLE_DESCRIPTION_USER));

        userAccountRepository.save(new UserAccount(roleAdmin, "admin"));
        userAccountRepository.save(new UserAccount(roleUser, "adnan"));
        userAccountRepository.save(new UserAccount(roleUser, "anisa"));
        userAccountRepository.save(new UserAccount(roleUser, "edin"));
        userAccountRepository.save(new UserAccount(roleUser, "lejla"));
    }

    private void seedData() {

        this.seedUsers();

        movieTimetableRepository.save(new MovieTimetable(
                1L,
                new Date(),
                10,
                100));
        movieTimetableRepository.save(new MovieTimetable(
                2L,
                new Date(),
                140,
                200));
        movieTimetableRepository.save(new MovieTimetable(
                3L,
                new Date(),
                200,
                300));
    }

}
