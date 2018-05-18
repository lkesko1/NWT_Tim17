import React, { Component } from "react";
import { fetchMovies } from "../../state/movie/actions";
import { getMovies } from "../../state/movie/stateSelector";
import { connect } from "react-redux";
import MoviesList from "./MoviesList";
import {Grid} from "semantic-ui-react";

class MoviesScreen extends Component {
  componentDidMount() {
    this.props.fetchMovies();
  }

  render() {
    const { movies } = this.props;

    return (
      <div>
        <Grid >
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <MoviesList movies={movies} />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}

export default connect(
  state => ({
    movies: getMovies(state)
  }),
  { fetchMovies }
)(MoviesScreen);
