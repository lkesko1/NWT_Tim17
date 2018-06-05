import React, { Component } from "react";
import {
  Item,
  Icon,
  Segment,
  List,
  Message,
  Divider,
  Label,
  Dimmer,
  Loader,
  Button
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import moment from "moment";
import { Link } from "react-router-dom";

export default class Projection extends Component {
  getMovieContent() {
    const role = localStorage.getItem("role");
    const isAdmin = role && role === "ROLE_ADMIN" ? true : false;
    const { movie, projection, showRemovalModal } = this.props;

    const content = (
      <Segment color="yellow">
        <Item.Group divided>
          <Item>
            <Item.Image style={{ marginTop: 20 }} size="small" src={logo} />

            <Item.Content>
              <Item.Header>{movie.title}</Item.Header>
              {isAdmin && (
                <Button
                  circular
                  size="mini"
                  floated="right"
                  color="red"
                  icon="remove"
                  content="Remove projection"
                  onClick={this.props.showRemovalModal}
                />
              )}
              <Item.Description>
                <List>
                  <List.Item>
                    <b> Year: </b> {movie.year}
                  </List.Item>
                  <List.Item>
                    <b> Genre: </b> {movie.genre}
                  </List.Item>
                  <List.Item>
                    <b> Actors: </b>
                    {movie.actors}
                  </List.Item>
                  <List.Item>
                    <b> Director: </b>
                    {movie.director}
                  </List.Item>
                  <List.Item>
                    <b> Awards: </b>
                    {movie.awards}
                  </List.Item>
                </List>
              </Item.Description>
              <Item.Extra>
                <Label color="red">
                  {" "}
                  Date: {moment(projection.date).format("YYYY-MM-DD")}
                </Label>

                <Label color="red">
                  Time: {moment(projection.date).format("HH:mm:ss")}
                </Label>
              </Item.Extra>
            </Item.Content>
          </Item>
        </Item.Group>
        <Divider />
      </Segment>
    );

    return content;
  }

  render() {
    const { movie, error, projection } = this.props;

    if (!projection && !error) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading" />
        </Dimmer>
      );
    }

    if (!movie || error || !projection) {
      return (
        <div>
          <Link to="/projections">
            <Button primary icon="video camera" content="View all projections" />
          </Link>
          <Message negative size="huge">
            <Message.Header>
              <Icon name="remove circle" />
              Sorry, we can't find movie!
            </Message.Header>
          </Message>
        </div>
      );
    }
    return <div>{this.getMovieContent()}</div>;
  }
}
