import React, { Component } from "react";
import {
  Item,
  Icon,
  Button,
  Segment,
  List,
  Message
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import { Link } from "react-router-dom";
import axios from "axios";
import {movieEndpoint} from "../../endpoints"

export default class MoviesList extends Component {
  constructor(props) {
    super(props);
    this.state = { movies: [], error: null };
  }

  componentWillMount() {
    axios.get(movieEndpoint + "/findAll")
    .then(response => {
      const movies = response.data;
      this.setState({movies: movies})
    })
    .catch(error => {
      this.setState({error: error})
    });
  }

  getContent() {
    const { movies } = this.state;
    let moviesList = [];
    let index = 0;

    for (let currentMovie of movies) {
      index += 1;
      // const currentMovie = movie;
      const content = (
        <Segment color="yellow" key={index}>
        <Item.Group divided>
          <Item>
            <Item.Image  style={{marginTop: 20}} size="small" src={logo} />

            <Item.Content>
              <Item.Header >{currentMovie.Title}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item> <b> Year: </b> {currentMovie.Year} </List.Item>
                  <List.Item> <b> Genre: </b> {currentMovie.Genre} </List.Item>
                  <List.Item> <b> Actors: </b>{currentMovie.Actors} </List.Item>
                </List>
              </Item.Description>
              <Item.Extra>
                <Icon color="green" name="check" /> {currentMovie.Ratings.length} Reviews
                <Link to="/movies/1">
                
                <Button primary floated="right">
                  View more
                  <Icon name="right chevron" />
                </Button>
                </Link>
                
              </Item.Extra>
            </Item.Content>
          </Item>
        </Item.Group>
        </Segment>
      );

      moviesList.push(content);
    }
    return moviesList;
  }

  render() {
    const { movies, error } = this.state;

    if (!movies || movies.length === 0 || error) {
      return (
        <Message negative size="huge">
          <Message.Header>
            <Icon name="remove circle" />
            We're sorry we can't find movies in database!
          </Message.Header>
        </Message>
      );
    }
    return <div>
       {this.getContent()} </div>;
  }
}

