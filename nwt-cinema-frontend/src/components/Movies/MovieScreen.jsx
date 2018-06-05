import React, { Component } from "react";
import Movie from "./Movie";
import { Grid } from "semantic-ui-react";
import axios from "axios";
import { movieEndpoint, reviewEndpoint } from "../../endpoints";

export default class MovieScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { movie: null, error: null, movieReviewText: "" };
  }

  updateForm(e, key, value) {
    if (key == "review") {
      this.setState({ ...this.state, movieReviewText: value });
    }
  }

  componentDidMount() {
    this.getMovie();
  }

  getMovie() {
    axios
      .get(movieEndpoint + "/" + this.props.match.params.id)
      .then(response => {
        const movie = response.data;
        this.setState({ ...this.state, movie: movie, movieReviewText: "" });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  addReview() {
    axios
      .post(reviewEndpoint + "/create", {
        comment: this.state.movieReviewText,
        movieId: this.state.movie.id
      })
      .then(response => {
        this.getMovie();
        this.setState({...this.state, movieReviewText: ""});
        console.log(this.state.movieReviewText);
        
      })
      .catch(error => {
        console.log(error);
        this.setState({ ...this.state, error: error });
      });
  }

  render() {
    
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
                movieReviewText={this.state.movieReviewText}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
