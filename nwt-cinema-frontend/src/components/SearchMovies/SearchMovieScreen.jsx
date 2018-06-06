import React, { Component } from "react";
import MovieSearchMovie from "./MovieSearchMovie";
import { Grid } from "semantic-ui-react";
import axios from "axios";
import { movieEndpoint } from "../../endpoints";
import { MovieModal } from "./MovieModal";

export default class SearchMovieScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { movie: null, error: null, modalVisible: false };
  }

  componentWillMount() {
    axios
      .get(
        // "http://www.omdbapi.com/?i=" + this.props.match.params.id + "&apikey=2d5ee0b5")
        movieEndpoint + "/omdb/" + this.props.match.params.id
      )
      .then(response => {
        const movie = response.data;
        this.setState({ ...this.state, movie: movie });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  showModal() {
    this.setState({
      ...this.state,
      modalVisible: true
    });
  }

  closeModal() {
    this.setState({
      ...this.state,
      modalVisible: false
    });
  }

  updateForm(e, key, value) {
    if (key == "youtube") {
      this.setState({ ...this.state, youtube: value });
    }
  }

  render() {
    const { movie, error } = this.state;

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <MovieSearchMovie
                movie={movie}
                error={error}
                showModal={this.showModal.bind(this)}
                closeModal={this.closeModal.bind(this)}
                updateForm={this.updateForm.bind(this)}
                modalVisible={this.state.modalVisible}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
