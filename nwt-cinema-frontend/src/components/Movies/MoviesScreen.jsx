import React, { Component } from "react";
// import { fetchMovies } from "../../state/movie/actions";
// import { getMovies } from "../../state/movie/stateSelector";
import { connect } from "react-redux";
import MoviesList from "./MoviesList";

class MoviesScreen extends Component {
  // componentDidMount() {
  //   this.props.fetchMovies();
  // }

  render() {
    const { movies } = this.props;

    console.log(movies);
    return (
      <div>
       <MoviesList />
      </div>
    );
  }
}

export default connect(
  // state => ({
  //   movies: getMovies(state)
  // }),
  // { fetchMovies }
)(MoviesScreen);
