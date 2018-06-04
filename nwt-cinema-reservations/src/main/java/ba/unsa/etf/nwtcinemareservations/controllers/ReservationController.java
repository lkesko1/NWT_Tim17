package ba.unsa.etf.nwtcinemareservations.controllers;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "reservations", produces = "application/json")
public class ReservationController extends BaseController<Reservation, ReservationService> {

    @Transactional(readOnly = true)
    @RequestMapping(value = "/get-reservations{userID}", method = RequestMethod.GET)
    public ResponseEntity fetchByName(@PathVariable("userID") final Long userID) {
        try {
            return ResponseEntity.ok(service.getReservationsByUserIDwDetails(userID));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
