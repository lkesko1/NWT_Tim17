package ba.unsa.etf.nwtcinemareservations.controllers;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.repositories.IUserAccountRepository;
import ba.unsa.etf.nwtcinemareservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.security.Principal;

@RestController
@RequestMapping(value = "reservations", produces = "application/json")
public class ReservationController extends BaseController<Reservation, ReservationService> {

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Transactional
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @Override
    public Reservation create(@RequestBody final Reservation reservation, Principal principal) {
        reservation.setUserAccount(userAccountRepository.findUserAccountByUsername(principal.getName()));
        return service.add(reservation);
    }
}
