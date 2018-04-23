package ba.unsa.etf.nwtcinemaprojections;

import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.models.Role;
import ba.unsa.etf.nwtcinemaprojections.models.UserRole;
import ba.unsa.etf.nwtcinemaprojections.repositories.IMovieTimetableRepository;
import ba.unsa.etf.nwtcinemaprojections.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemaprojections.repositories.IUserRoleRepository;
import ba.unsa.etf.nwtcinemaprojections.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private static final String ROLE_TITLE_ADM = "Administrator";
    private static final String ROLE_DESCRIPTION_ADM = "Administrator";

    private static final String ROLE_TITLE_USR = "User";
    private static final String ROLE_DESCRIPTION_USR = "User";

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
    private IUserRoleRepository userRoleRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {

        final Role roleAdm = roleRepository.save(new Role(ROLE_TITLE_ADM, ROLE_DESCRIPTION_ADM));
        final Role roleUsr = roleRepository.save(new Role (ROLE_TITLE_USR, ROLE_DESCRIPTION_USR));

        final UserRole userRoleAdm = userRoleRepository.save(new UserRole(roleAdm, USER_ADM));
        final UserRole userRoleUsr1 = userRoleRepository.save(new UserRole(roleUsr, USER_USR_ONE));
        final UserRole userRoleUsr2 = userRoleRepository.save(new UserRole(roleUsr, USER_USR_TWO));



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
