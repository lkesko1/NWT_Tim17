package ba.unsa.etf.nwtcinemaprojections.repositories;

import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieTimetableRepository extends JpaRepository<MovieTimetable, Long> {
}
