package ba.unsa.etf.nwtcinemaprojections.services;

import ba.unsa.etf.nwtcinemaprojections.RabbitMQConfiguration;
import ba.unsa.etf.nwtcinemaprojections.controllers.dto.TicketReservationDTO;
import ba.unsa.etf.nwtcinemaprojections.feign_clients.MoviesClient;
import ba.unsa.etf.nwtcinemaprojections.feign_clients.dto.MovieDTO;
import ba.unsa.etf.nwtcinemaprojections.models.MovieTimetable;
import ba.unsa.etf.nwtcinemaprojections.repositories.IMovieTimetableRepository;
import dto.movies.OMDBMovie;
import dto.projections.MovieProjectionDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieTimetableService extends BaseService<MovieTimetable, IMovieTimetableRepository>{

    @Autowired
    private MoviesClient moviesClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void reserveTickets(TicketReservationDTO ticketReservation) throws Exception {
        Optional<MovieTimetable> timetable = this.repository.findById(ticketReservation.getProjectionId());
        int newNumberOfTickets = timetable.get().getActualTickets() + ticketReservation.getTickets();
        if (newNumberOfTickets > timetable.get().getMaxTickets()) {
            throw new Exception("No enough room");
        }
        timetable.get().setActualTickets(newNumberOfTickets);
        this.repository.save(timetable.get());
    }

    @Override
    public MovieTimetable add(MovieTimetable movieProjection) {
        try {

            Long movieId = movieProjection.getMovieID();
            MovieDTO movieDTO = moviesClient.getMovie(movieId);

//            Ovdje ce ici movieDTO.getId() == null
            if (movieDTO.getTitle() == null) {
                throw new Exception("Movie does not exist");
            }

//            moviesClient.addProjection(new MovieProjectionDTO(
//                    movieDTO.getId(),
//                    movieProjection.getCreatedBy(),
//                    new Date(),
//                    movieProjection.getActualTickets(),
//                    movieProjection.getMaxTickets()
//            ));

            rabbitTemplate.convertAndSend(
                    RabbitMQConfiguration.NWT_CINEMA_EXCHANGE,
                    "movieProjections.created",
                    String.format("movieProjections=%s", movieProjection.getMovieID()));

            return super.add(movieProjection);
        }
        catch (Exception exception) {
            return null;
        }
    }
    public MovieDTO getDetails(Long movieId){
        return moviesClient.getMovieDetails(movieId);

    }

    public List<MovieProjectionDetailsDTO> getActualProjections() {
        List<MovieProjectionDetailsDTO> movieProjectionDetailsDTOS = new ArrayList<>();
        List<MovieTimetable> movieTimetables = this.repository.findAll();
        // TODO filter by date -> move to repository | fix a bug with not autogenerating methods in repositories
        for (MovieTimetable movieTimetable : movieTimetables) {
            MovieDTO movieDTO = moviesClient.getMovieDetails(movieTimetable.getMovieID());
            //

            movieProjectionDetailsDTOS.add(
                    new MovieProjectionDetailsDTO(
                            movieTimetable.getActualTickets(),
                            movieTimetable.getMaxTickets(),
                            movieTimetable.getDate(),
                            new OMDBMovie() // todo fill with props
                    )
            );
        }

        return movieProjectionDetailsDTOS;
    }


}
