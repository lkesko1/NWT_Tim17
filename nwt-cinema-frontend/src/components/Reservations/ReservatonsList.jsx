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

export default class ReservationsList extends Component {
  getContent() {
    const { reservations } = this.props;
    let reservationsList = [];
    let index = 0;

    for (let currentReservation of reservations) {
      index += 1;
      // const currentMovie = movie;
      const content = (
        <Segment color="yellow" key={index}>
        <Item.Group divided>
          <Item>
            <Item.Image  style={{marginTop: 20}} size="small" src={logo} />

            <Item.Content>
              <Item.Header >{currentReservation.Title}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item> <b> Year: </b> {currentReservation.Year} </List.Item>
                  <List.Item> <b> Genre: </b> {currentReservation.Genre} </List.Item>
                  <List.Item> <b> Actors: </b>{currentReservation.Actors} </List.Item>
                </List>
              </Item.Description>
              <Item.Extra>
                <Icon color="green" name="check" /> {currentReservation.Ratings.length} Reviews
                <Link to="/reservations/1">

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

      reservationsList.push(content);
    }
    return reservationsList;
  }

  render() {
    const { reservations, error } = this.props;

    if (!reservations || reservations.length === 0 || error) {
      return (
        <Message negative size="huge">
          <Message.Header>
            <Icon name="remove circle" />
            We're sorry we can't find reservations in database!
          </Message.Header>
        </Message>
      );
    }
    return <div>
       {this.getContent()} </div>;
  }
}

