import React, { Component } from "react";
import Movie from "./Movie";
import {Grid} from "semantic-ui-react";
import axios from "axios";
import {movieEndpoint} from "../../endpoints";

export default class MovieScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { movie: null, error: null };
  }

  componentWillMount() {
    axios.get(movieEndpoint + "/1")
    .then(response => {
      const movie = response.data;
      this.setState({movie: movie})
    })
    .catch(error => {
      this.setState({error: error})
    });
  }

  render() {
    const {movie, error} = this.state;

    return (
      <div>
        <Grid >
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Movie movie={movie} error={error}/>
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
