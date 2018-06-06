import React, { Component } from "react";
import {
  Dimmer,
  Loader,
  Item,
  Icon,
  Segment,
  Grid,
  List,
  Message
} from "semantic-ui-react";
import logo from "../../images/ticket.png";
import moment from "moment";

export class ReservationsList extends Component {
  getContent() {
    const { reservations } = this.props;
    let reservationsList = [];

    for (let currentReservation of reservations) {
      console.log(currentReservation);
      const content = (
        <Grid.Column key={currentReservation.id}>
        <div >
        
        <Segment color="yellow" >
          <Item.Group >
            <Item>
              <Item.Image style={{ marginTop: 20 }} size="tiny" src={logo} />

              <Item.Content>
                <Item.Header />
                <Item.Description>
                  <List>
                    <List.Item>
                      <b> Number of tickets: </b>{" "}
                      {currentReservation.numberOfTickets}{" "}
                    </List.Item>
                    <List.Item>
                      <b> Date created: </b>{" "}
                      {moment(currentReservation.dateCreated).format(
                        "DD-MM-YYYY"
                      )}
                    </List.Item>
                    <List.Item>
                      <b> User: </b> {currentReservation.userAccount.username}{" "}
                    </List.Item>
                  </List>
                </Item.Description>
              </Item.Content>
            </Item>
          </Item.Group>
        </Segment>
        </div>
        </Grid.Column>
      );

      reservationsList.push(content);
    }
    return reservationsList;
  }

  render() {
    const { reservations, error, movie, projection } = this.props;

    if (!reservations && !error) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading reservations" />
        </Dimmer>
      );
    }

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
    console.log(movie);
    return (
        <Grid columns={2} divided>
          <Grid.Row centered>
            {this.getContent()}
          </Grid.Row>
        </Grid>
    );
  }
}
