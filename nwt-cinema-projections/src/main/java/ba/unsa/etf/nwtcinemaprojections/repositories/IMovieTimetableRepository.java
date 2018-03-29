package ba.unsa.etf.nwtcinemaprojections.repositories;

import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieTimetableRepository extends JpaRepository<MovieTimetable, Long> {
}
