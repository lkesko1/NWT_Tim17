package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import ba.unsa.etf.nwtcinemareservations.repositories.IReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends BaseService<Reservation, IReservationRepository> {
}

