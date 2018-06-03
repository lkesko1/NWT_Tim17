import React, { Component } from "react";
import MoviesList from "./MoviesList";
import { Grid, Button, Divider } from "semantic-ui-react";
import axios from "axios";
import { movieEndpoint } from "../../endpoints";
import { Link } from "react-router-dom";

export default class MoviesScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { movies: [], error: null };
  }

  componentDidMount() {
    // let token = localStorage.getItem("token");
    // if (token) {
    //   axios.defaults.headers['Authorization'] = token;
    // }
    // console.log('axios defaults', axios.defaults)
    // console.log(axios.defaults.headers['Authorization']);
    axios
      .get(movieEndpoint + "/findAll")
      .then(response => {
        const movies = response.data;
        this.setState({ movies: movies });
      })
      .catch(error => {
        this.setState({ error: error });
      });
  }

  render() {
    const { movies, error } = this.state;

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Link to="/search">
                <Button
                  positive
                  labelPosition="right"
                  icon="search"
                  content="Search and add movies"
                />
              </Link>
              <Divider hidden />
              <MoviesList movies={movies} error={error} />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
