import Api from "../../api.js";

export const SET_MOVIES = "SET_MOVES";

export const setMovies = data => ({
  type: SET_MOVIES,
  movies: data
});

export const fetchMovies = () => dispatch => {
  console.log("OK");
  Api.get("movies/movies")
    .then(response => {
      console.log(response);
      const data = response.data.data;
      dispatch(setMovies(data));
    })
    .catch(error => {});
};
