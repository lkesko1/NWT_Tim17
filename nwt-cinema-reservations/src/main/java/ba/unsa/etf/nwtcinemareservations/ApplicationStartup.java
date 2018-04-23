package ba.unsa.etf.nwtcinemareservations;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.models.Role;
import ba.unsa.etf.nwtcinemareservations.models.UserRole;
import ba.unsa.etf.nwtcinemareservations.repositories.IReservationRepository;
import ba.unsa.etf.nwtcinemareservations.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemareservations.repositories.IUserRoleRepository;
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

    private static final Long MOVIEPROJID = 10L;
    private static final Long MOVIEPROJID2 = 20L;

    @Autowired
    private IRoleRepository roleRepository ;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Autowired
    private IReservationRepository iReservationRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {

        final Role roleAdm = roleRepository.save(new Role(ROLE_TITLE_ADM, ROLE_DESCRIPTION_ADM));
        final Role roleUsr = roleRepository.save(new Role(ROLE_TITLE_USR, ROLE_DESCRIPTION_USR));

        final UserRole userRoleAdm = userRoleRepository.save(new UserRole(roleAdm, USER_ADM));
        final UserRole userRoleUsr1 = userRoleRepository.save(new UserRole(roleUsr, USER_USR_ONE));
        final UserRole userRoleUsr2 = userRoleRepository.save(new UserRole(roleUsr, USER_USR_TWO));

        final Reservation reservation1 = iReservationRepository.save(new Reservation(USER_USR_ONE, MOVIEPROJID, 3, new Date(2018, 2,3)));
        final Reservation reservation2 = iReservationRepository.save(new Reservation(USER_USR_ONE, MOVIEPROJID2, 2, new Date(2018, 2,3)));
        final Reservation reservation3 = iReservationRepository.save(new Reservation(USER_USR_TWO, MOVIEPROJID2, 2,  new Date(2018, 4, 3)));
    }

    }
