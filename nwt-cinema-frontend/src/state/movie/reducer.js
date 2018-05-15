import { SET_MOVIES } from "./actions";

export default function reducer(state = {}, action) {
  switch (action.type) {
    case SET_MOVIES: {
      return {
        ...state,
        movies: action.movies
      };
    }

    default:
      return state;
  }
}
