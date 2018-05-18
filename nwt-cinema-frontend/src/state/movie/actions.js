import axios from "axios";

export const SET_MOVIES = "SET_MOVIES";
export const SET_MOVIE = "SET_MOVIE";
export const SET_MOVIE_YOUTUBE = "SET_MOVIE_YOUTUBE";

export const setMovies = data => ({
  type: SET_MOVIES,
  movies: data
});

export const setMovie = (data) => ({
  type: SET_MOVIE,
  movie: data,
});

const movieEndpoint = "http://localhost:8080/movies/movies/";

export const fetchMovies = () => dispatch => {
  axios.get(movieEndpoint + "/findAll")
    .then(response => {
      const data = response.data;
      dispatch(setMovies(data));
    })
    .catch(error => {});
};

export const fetchMovie = () => dispatch => {
  
  axios.get(movieEndpoint + "/1")
    .then(response => {
      const data = response.data;
      dispatch(setMovie(data));
    })
    .catch(error => {});
    
};
