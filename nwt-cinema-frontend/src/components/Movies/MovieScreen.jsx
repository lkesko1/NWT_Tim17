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

  addReview() {
    console.log(this.props.movieReviewText);
    // axios
    //   .post(reviewEndpoint + "/create", {
    //     userId: currentUser,
    //     rate: currentRate,
    //     comment: this.state.movieReviewText,
    //     movie: this.props.movie
    //   })
    //   .then(response => {
    //     console.log(response);
    //   })
    //   .catch(error => {
    //     console.log(error);
    //   });
  }

  updateForm(e, key, value) {
    if (key == "review") {
      this.setState({ ...this.state, movieReviewText: value });
    }
  }


  componentWillMount() {
    axios
      .get(movieEndpoint + "/1")
      .then(response => {
        const movie = response.data;
        this.setState({ ...this.state, movie: movie });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  render() {
    const { movie, error } = this.state;

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Movie
                movie={movie}
                error={error}
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
