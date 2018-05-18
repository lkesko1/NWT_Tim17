import React, { Component } from "react";
import Movie from "./Movie";
import {Grid} from "semantic-ui-react";

export default class MovieScreen extends Component {
  render() {
    return (
      <div>
        <Grid >
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Movie/>
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
