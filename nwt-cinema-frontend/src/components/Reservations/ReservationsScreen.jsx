import React, { Component } from "react";
import { ReservationsList }  from "./ReservationsList";
import { Grid, Divider } from "semantic-ui-react";
import axios from "axios";
import { reservationsEndpoint } from "../../endpoints";

export default class ReservationsScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { reservations: [], error: null };
  }

  componentDidMount() {
    axios
      .get(reservationsEndpoint + "/get-reservations" + this.props.match.params.id)
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

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Divider hidden />
              <ReservationsList reservations={reservations} error={error} />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
