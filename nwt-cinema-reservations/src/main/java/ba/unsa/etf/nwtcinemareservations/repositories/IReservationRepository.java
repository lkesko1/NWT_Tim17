package ba.unsa.etf.nwtcinemareservations.repositories;

import ba.unsa.etf.nwtcinemareservations.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
