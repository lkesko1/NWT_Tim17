package ba.unsa.etf.nwtcinemareservations.controllers;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.repositories.IUserAccountRepository;
import ba.unsa.etf.nwtcinemareservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @Transactional(readOnly = true)
    @RequestMapping(value = "/get-reservations/{userID}", method = RequestMethod.GET)
    public ResponseEntity fetchByUser(@PathVariable("userID") final Long userID) {
        try {
            return ResponseEntity.ok(service.getReservationsByUserIDwDetails(userID));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

    @Transactional(readOnly = true)
    @RequestMapping(value = "/get-reservations-proj/{projID}", method = RequestMethod.GET)
    public ResponseEntity fetchByProjection(@PathVariable("projID") final Long projID) {
        try {
            return ResponseEntity.ok(service.getReservationsByProjectionID(projID));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }
}
