import { SET_PROJECTIONS } from "./actions";

export default function reducer(state = {}, action) {
  switch (action.type) {
    case SET_PROJECTIONS: {
      return {
        ...state,
        projections: action.projections
      };
    }

    default:
      return state;
  }
}
