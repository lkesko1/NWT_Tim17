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
    const role = localStorage.getItem("role")
    const { movies, error } = this.state;

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
            <h3> Cinema movies </h3>
              {role === "ROLE_ADMIN" && (
                <div>
                  <Link to="/search">
                    <Button
                      positive
                      labelPosition="right"
                      icon="search"
                      content="Search and add movies"
                    />
                  </Link>
                  <Divider hidden />
                </div>
              )}
              <MoviesList movies={movies} error={error} />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
