import React, { Component } from "react";
import SearchInput, { createFilter } from "react-search-input";
import { movieEndpoint } from "../../endpoints";
import axios from "axios";
import {
  List,
  Button,
  Icon,
  Card,
  Grid,
  Input,
  Message,
  Segment
} from "semantic-ui-react";
import { Link } from "react-router-dom";

export default class Search extends Component {
  constructor(props) {
    super(props);
    this.state = {
      searchTerm: "",
      searchedMovies: {
        Search: []
      }
    };
    this.searchUpdated = this.searchUpdated.bind(this);
  }

  myFunction(term) {
    axios
      .get(
        //movieEndpoint + "/get-movies/" + term.target.value)
        "http://www.omdbapi.com/?s=" + term.target.value + "&apikey=2d5ee0b5"
      )
      .then(response => {
        const movies = response.data;
        if (movies.Search == null) {
          this.setState({
            searchedMovies: null
          });
        }
        // searchedMovies: {
        //     "Search": [{"imdbID" : "1",
        //         "Title" : "NotFound",
        //         "Year":"Not Found"}]
        // }})}
        else {
          this.setState({
            searchedMovies: movies
          });
        }
      })
      .catch(error => {
        this.setState({ error: error });
      });
  }

  setMovies() {
    if (this.state.searchedMovies) {
      return (
        <div className="ui centered cards">
          {this.state.searchedMovies.Search.map(movie => (
            <div className="card" key={movie.imdbID}>
              <div className="content">
                <List>
                  <List.Item>{movie.Title}</List.Item>
                  <List.Item>{movie.Year}</List.Item>
                </List>
              </div>
              <div className="extra content">
                <Link to={"/search/" + movie.imdbID}>
                  <Button primary floated="right">
                    View more
                    <Icon name="right chevron" />
                  </Button>
                </Link>
              </div>
            </div>
          ))}
        </div>
      );
    }
    return (
      <Grid>
        <Grid.Column width={8} >
          <Message icon compact warning size="large">
            <Icon name="search" />
            <Message.Content>
              <Message.Header>Movie search</Message.Header>
              Movie not found.
            </Message.Content>
          </Message>
        </Grid.Column>
      </Grid>
    );
  }

  render() {
    return (
      <Grid>
        <Grid.Row>
          <Grid.Column width={2} />
          <Grid.Column width={12}>
            <Segment color="yellow">
              <Grid>
                <Grid.Column width={8}>
                  <Input
                    fluid
                    icon={<Icon name="search" inverted circular link />}
                    iconPosition="right"
                    placeholder="Type here..."
                    onChange={this.myFunction.bind(this)}
                  />
                </Grid.Column>
              </Grid>
            </Segment>

            <div className="ui hidden divider" />
            {this.setMovies()}
          </Grid.Column>
          <Grid.Column width={2} />
        </Grid.Row>
      </Grid>
    );
  }

  searchUpdated(term) {
    this.myFunction(term);
  }
}
