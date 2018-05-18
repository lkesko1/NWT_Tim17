import React, { Component } from "react";
import MoviesList from "./MoviesList";
import {Grid} from "semantic-ui-react";
import axios from "axios";
import {movieEndpoint} from "../../endpoints";

export default class MoviesScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { movies: [], error: null };
  }

  componentWillMount() {
    axios.get(movieEndpoint + "/findAll")
    .then(response => {
      const movies = response.data;
      this.setState({movies: movies})
    })
    .catch(error => {
      this.setState({error: error})
    });
  }

  render() {
    const {movies, error} = this.state;

    return (
      <div>
        <Grid >
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <MoviesList movies={movies} error={error}/>
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
