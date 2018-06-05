import React, { Component } from "react";
import {
  Item,
  Icon,
  Button,
  Segment,
  List,
  Message,
  Dimmer,
  Loader
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import { Link } from "react-router-dom";

export default class MoviesList extends Component {
  getContent() {
    const { movies } = this.props;
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
              <Item.Header >{currentMovie.title}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item> <b> Year: </b> {currentMovie.year} </List.Item>
                  <List.Item> <b> Genre: </b> {currentMovie.genre} </List.Item>
                  <List.Item> <b> Actors: </b>{currentMovie.actors} </List.Item>
                </List>
              </Item.Description>
              <Item.Extra>
                <Icon color="green" name="check" />  Reviews
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
    const { movies, error } = this.props;

    if (!movies && !error) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading" />
        </Dimmer>
      );
    }

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

