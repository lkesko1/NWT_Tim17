import { SET_MOVIES, SET_MOVIE} from "./actions";

export default function reducer(state = {}, action) {
  switch (action.type) {
    case SET_MOVIES: {
      return {
        ...state,
        movies: action.movies
      };
    }

    case SET_MOVIE: {
      return {
        ...state,
        movie: action.movie,
        youtube: action.youtube
      }
    }

    default:
      return state;
  }
}

