import React, { Component } from "react";
import {
  Item,
  Icon,
  Button,
  Segment,
  List,
  Message,
  Embed,
  Divider
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import { fetchMovie } from "../../state/movie/actions";
import { getMovie } from "../../state/movie/stateSelector";
import { connect } from "react-redux";
import image from "../../images/DMOHA20140112005.jpg"

class Movie extends Component {
  // componentDidUpdate() {
  //   this.props.fetchMovies();
  // }

  getMovieContent() {
    const { movie, youtubeId } = this.props;

    const content = (
      <Segment color="yellow" >
        <Item.Group divided>
          <Item>
            <Item.Image style={{marginTop: 20}} size="small" src={logo} />

            <Item.Content>
              <Item.Header>{movie.Title}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item>
                    <b> Year: </b> {movie.Year}
                  </List.Item>
                  <List.Item>
                    <b> Genre: </b> {movie.Genre}
                  </List.Item>
                  <List.Item>
                    <b> Actors: </b>
                    {movie.Actors}
                  </List.Item>
                  <List.Item>
                    <b> Director: </b>
                    {movie.Director}
                  </List.Item>
                  <List.Item>
                    <b> Awards: </b>
                    {movie.Awards}
                  </List.Item>
                </List>
              </Item.Description>
            </Item.Content>
          </Item>
        </Item.Group>
        <Divider/>

        <Embed
          id="do9zep1n8cU"
          placeholder={image}
          source="youtube"
        />
      </Segment>
    );

    return content;
  }

  render() {
    const { movie } = this.props;

    if (!movie) {
      return (
        <Message negative size="huge">
          <Message.Header>
            <Icon name="remove circle" />
            Sorry, we can't find movie!
          </Message.Header>
        </Message>
      );
    }
    return <div>{this.getMovieContent()}</div>;
  }
}

export default connect(
  state => ({
    movie: getMovie(state),
    // youtubeId: getMovieFromYoutube(state),
  }),
  { fetchMovie }
)(Movie);
