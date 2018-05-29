import React, { Component } from "react";
import SearchInput, { createFilter } from "react-search-input";
import { movieEndpoint } from "../../endpoints";
import axios from "axios";
import { List, Button, Icon, Card } from "semantic-ui-react";
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
        <div class="ui cards">
          {this.state.searchedMovies.Search.map(movie => (
            <div class="card" key={movie.imdbID}>
              <div class="content">
                <List>
                  <List.Item>{movie.Title}</List.Item>
                  <List.Item>{movie.Year}</List.Item>
                </List>
              </div>
              <div class="extra content">
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
    return <div class="ui cards">Not found</div>;
  }

  render() {
    return (
      <div>
        <div class="ui icon input">
          <i class="search icon" />
          <input
            type="text"
            onChange={this.myFunction.bind(this)}
            placeholder="Type here..."
          />
        </div>

        <div class="ui hidden divider" />
        {this.setMovies()}
      </div>
    );
  }

  searchUpdated(term) {
    this.myFunction(term);
  }
}
