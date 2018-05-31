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



    private static final Long USER_ADM = 1000L;
    private static final Long USER_USR_ONE = 1001L;
    private static final Long USER_USR_TWO = 1002L;



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

    private void seedData() {

        final Role roleAdmin = roleRepository.save(new Role(RoleService.ROLE_ADMIN, RoleService.ROLE_DESCRIPTION_ADMIN));
        final Role roleUser = roleRepository.save(new Role (RoleService.ROLE_USER, RoleService.ROLE_DESCRIPTION_USER));

//        final UserAccount adminUser = userAccountRepository.save(new UserAccount(roleAdmin, ));
//        final UserAccount userRoleUsr1 = userRoleRepository.save(new UserAccount(roleUsr, USER_USR_ONE));
//        final UserAccount userRoleUsr2 = userRoleRepository.save(new UserAccount(roleUsr, USER_USR_TWO));



        movieTimetableRepository.save(new MovieTimetable(
                new Long(1),
                new Long(1),
                new Date(),
                10,
                100));
        movieTimetableRepository.save(new MovieTimetable(
                new Long(2),
                new Long(2),
                new Date(),
                140,
                200));
        movieTimetableRepository.save(new MovieTimetable(
                new Long(3),
                new Long(3),
                new Date(),
                200,
                300));
    }

}
