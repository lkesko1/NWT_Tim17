import React, { Component } from "react";
import MoviesList from "./MoviesList";
import {Grid} from "semantic-ui-react";

export default class MoviesScreen extends Component {

  render() {

    return (
      <div>
        <Grid >
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <MoviesList />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
