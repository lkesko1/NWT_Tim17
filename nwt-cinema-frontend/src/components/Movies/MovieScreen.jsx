import React, { Component } from "react";
import { fetchMovie } from "../../state/movie/actions";
import { getMovie } from "../../state/movie/stateSelector";
import { connect } from "react-redux";
import Movie from "./Movie";
import {Grid} from "semantic-ui-react";

class MovieScreen extends Component {
  componentDidMount() {
    this.props.fetchMovie();
  }

  render() {
    const { movie } = this.props;
    console.log(movie)
    return (
      <div>
        <Grid >
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Movie movie={movie} />
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
    movie: getMovie(state)
  }),
  { fetchMovie }
)(MovieScreen);
