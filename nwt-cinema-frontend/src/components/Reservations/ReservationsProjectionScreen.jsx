import React, { Component } from "react";
import { ReservationsProjectionList } from "./ReservationsProjectionList";
import {Header,  Grid, Divider, Label } from "semantic-ui-react";
import axios from "axios";
import { reservationsEndpoint, projectionsEndpoint } from "../../endpoints";
import { ReservationsList } from "./ReservationsList";
import moment from "moment";

export default class ReservationsProjectionScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { reservations: null, error: null };
  }

  getProjection() {
    axios
      .get(projectionsEndpoint + "/" + this.props.match.params.id)
      .then(response => {
        const projection = response.data;
        this.setState({ ...this.state, projection: projection });
        axios
          .get(
            projectionsEndpoint +
              "/get-details/" +
              this.state.projection.movieID
          )
          .then(response => {
            let movie = response.data;
            this.setState({ ...this.state, movie: movie });
          })
          .catch(error => {
            this.setState({ ...this.state, error: error });
          });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  componentDidMount() {
    axios
      .get(
        reservationsEndpoint +
          "/get-reservations-proj/" +
          this.props.match.params.id
      )
      .then(response => {
        const reservations = response.data;
        this.setState({ ...this.state, reservations: reservations });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });

    this.getProjection();
  }

  render() {
    const { reservations, error, projection, movie } = this.state;

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              {movie &&
                projection && (
                  <div>
                    <Header as="h3" color="red"> Projection: {movie.title} </Header>
                    <b> Date:  </b>
                    <Label color="red">
                      {moment(projection.date).format("DD-MM-YYYY")}{" "}
                    </Label>
                  </div>
                )}
              <Divider hidden />
              <ReservationsList
                reservations={reservations}
                error={error}
                movie={movie}
                projection={projection}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
3