import React, { Component } from "react";
import {
  Item,
  Icon,
  Segment,
  List,
  Message
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";

export class ReservationsProjectionList extends Component {
  getContent() {
    const { reservations } = this.props;
    let reservationsList = [];
    let index = 0;

    for (let currentReservation of reservations) {
      index += 1;
      const content = (
        <Segment color="yellow" key={index}>
        <Item.Group divided>
          <Item>
            <Item.Image  style={{marginTop: 20}} size="small" src={logo} />

            <Item.Content>
              <Item.Header >{currentReservation.userAccount.username}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item> <b> Number of tickets: </b> {currentReservation.numberOfTickets} </List.Item>
                  <List.Item> <b> Date created: </b> {currentReservation.dateCreated} </List.Item>
                </List>
              </Item.Description>
             
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

