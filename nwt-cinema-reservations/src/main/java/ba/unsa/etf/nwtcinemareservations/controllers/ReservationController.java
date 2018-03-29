package ba.unsa.etf.nwtcinemareservations.controllers;

import ba.unsa.etf.nwtcinemareservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reservations", produces = "application/json")
public class ReservationController extends BaseController<ReservationService> {

}
