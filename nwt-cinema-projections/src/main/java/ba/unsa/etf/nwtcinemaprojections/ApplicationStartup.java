package ba.unsa.etf.nwtcinemaprojections;

import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.repositories.IMovieTimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Autowired
    private IMovieTimetableRepository movieTimetableRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {
        movieTimetableRepository.save(new MovieTimetable(
                new Long(1),
                new Long(1),
                new Date(),
                0,
                100));
        movieTimetableRepository.save(new MovieTimetable(
                new Long(2),
                new Long(2),
                new Date(),
                0,
                200));
        movieTimetableRepository.save(new MovieTimetable(
                new Long(3),
                new Long(3),
                new Date(),
                0,
                300));
    }

}
