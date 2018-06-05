import React, { Component } from "react";
import Movie from "./Movie";
import { Grid } from "semantic-ui-react";
import axios from "axios";
import { movieEndpoint } from "../../endpoints";

export default class MovieScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { movie: null, error: null };
  }

  updateForm(e, key, value) {
    if (key == "review") {
      this.setState({ ...this.state, movieReviewText: value });
    }
  }

  addReview() {}

  componentWillMount() {
    axios
      .get(movieEndpoint + "/" + this.props.match.params.id)
      .then(response => {
        const movie = response.data;
        this.setState({ movie: movie });
      })
      .catch(error => {
        this.setState({ error: error });
      });
  }

  addReview() {
    axios
      .post(movieEndpoint + "/review/create", {
        userId: localStorage.getItem("user"),
        comment: this.state.movieReviewText,
        movie: this.state.movie
      })
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    console.log(this.state.movie);

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Movie
                movie={this.state.movie}
                error={this.state.error}
                updateForm={this.updateForm.bind(this)}
                addReview={this.addReview.bind(this)}
                movieReviewText={this.props.movieReviewText}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
