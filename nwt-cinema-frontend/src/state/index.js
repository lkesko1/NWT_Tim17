import { combineReducers } from "redux";
import movie from "./movie/reducer";
import projection from "./projection/reducer";

export default combineReducers({
  movie,
  projection
});
