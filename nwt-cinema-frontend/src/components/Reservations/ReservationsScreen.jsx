import React, { Component } from "react";
import { UserReservations } from "./UserReservations";
import { Grid, Divider, Header, Icon } from "semantic-ui-react";
import axios from "axios";
import { reservationsEndpoint } from "../../endpoints";
import { Redirect } from "react-router-dom";

export default class ReservationsScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { reservations: [], error: null };
  }

  componentDidMount() {
    axios
      .get(
        reservationsEndpoint + "/get-reservations/" + this.props.match.params.id
      )
      .then(response => {
        const reservations = response.data;
        this.setState({ reservations: reservations });
      })
      .catch(error => {
        this.setState({ error: error });
      });
  }

  render() {
    const { reservations, error } = this.state;
    // if (localStorage.getItem("role") != "ROLE_ADMIN") {
    //   return <Redirect to="/login" />;
    // }
    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Header as="h3" color="red">
                <Icon name="ticket" />
                My reservations
              </Header>
              <Divider />
              <UserReservations reservations={reservations} error={error} />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
