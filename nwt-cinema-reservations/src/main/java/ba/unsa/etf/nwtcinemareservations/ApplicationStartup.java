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

    @Autowired
    private IRoleRepository roleRepository ;

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Autowired
    private IReservationRepository iReservationRepository;

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

        iReservationRepository.save(new Reservation(userAccountRepository.findUserAccountByUsername("adnan"), 1L, 3, new Date(2018, 2,3)));
        iReservationRepository.save(new Reservation(userAccountRepository.findUserAccountByUsername("anisa"), 2L, 2, new Date(2018, 2,3)));
        iReservationRepository.save(new Reservation(userAccountRepository.findUserAccountByUsername("edin"), 2L, 2, new Date(2018, 4, 3)));
    }
}
