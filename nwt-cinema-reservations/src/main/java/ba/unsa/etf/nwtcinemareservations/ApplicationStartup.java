package ba.unsa.etf.nwtcinemareservations;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.models.Role;
import ba.unsa.etf.nwtcinemareservations.models.UserAccount;
import ba.unsa.etf.nwtcinemareservations.repositories.IReservationRepository;
import ba.unsa.etf.nwtcinemareservations.repositories.IRoleRepository;
import ba.unsa.etf.nwtcinemareservations.repositories.IUserAccountRepository;
import ba.unsa.etf.nwtcinemareservations.services.RoleService;
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

    private static final Long MOVIEPROJID = 10L;
    private static final Long MOVIEPROJID2 = 20L;

    @Autowired
    private IRoleRepository roleRepository ;

    @Autowired
    private IUserAccountRepository userRoleRepository;

    @Autowired
    private IReservationRepository iReservationRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {

        final Role roleAdmin = roleRepository.save(new Role(RoleService.ROLE_ADMIN, RoleService.ROLE_DESCRIPTION_ADMIN));
        final Role roleUser = roleRepository.save(new Role (RoleService.ROLE_USER, RoleService.ROLE_DESCRIPTION_USER));


        final UserAccount userRoleAdm = userRoleRepository.save(new UserAccount(roleAdmin, "admin"));
//        final UserAccount userRoleUsr1 = userRoleRepository.save(new UserAccount(roleUser, USER_USR_ONE));
//        final UserAccount userRoleUsr2 = userRoleRepository.save(new UserAccount(roleUser, USER_USR_TWO));

        final Reservation reservation1 = iReservationRepository.save(new Reservation(USER_USR_ONE, MOVIEPROJID, 3, new Date(2018, 2,3)));
        final Reservation reservation2 = iReservationRepository.save(new Reservation(USER_USR_ONE, MOVIEPROJID2, 2, new Date(2018, 2,3)));
        final Reservation reservation3 = iReservationRepository.save(new Reservation(USER_USR_TWO, MOVIEPROJID2, 2,  new Date(2018, 4, 3)));
    }

    }
