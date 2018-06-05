import React, { Component } from "react";
import ProjectionsList from "./ProjectionsList";
import { Grid, Segment } from "semantic-ui-react";
import axios from "axios";
import { Redirect } from "react-router-dom";
import { projectionsEndpoint, movieEndpoint } from "../../endpoints";
import moment from "moment";

export default class ProjectionsScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      projections: null,
      error: null,
      movies: [],
      redirect: false
    };
  }

  saveProjection() {
    const { selectedMovieId, selectedDate, numberOfTickets } = this.state;

    axios
      .post(projectionsEndpoint + "/create", {
        movieID: selectedMovieId,
        createdBy: 1,
        date: selectedDate,
        actualTickets: 0,
        maxTickets: numberOfTickets
      })
      .then(response => {
        this.hideProjectionModal();
        this.getProjections();
      })
      .catch(error => {
        console.log(error);
      });
  }

  hideProjectionModal() {
    this.setState({
      ...this.state,
      projectionModalVisible: false,
      error: null,
      selectedMovieId: null,
      numberOfTickets: 0
    });
  }

  showProjectionModal() {
    this.setState({
      ...this.state,
      projectionModalVisible: true,
      selectedMovieId: this.state.movies[0].id,
      numberOfTickets: 100
    });
  }

  showReservationModal(id) {
    if (localStorage.getItem("token")) {
      this.setState({
        reservationModalVisible: true,
        selectedProjectionId: id,
        error: null
      });
    } else {
      this.props.redirect();
    }
  }

  hideReservationModal() {
    this.setState({
      reservationModalVisible: false,
      selectedProjectionId: null,
      error: null
    });
  }

  updateForm(e, key, value) {

    if (key == "projection") {
      this.setState({ ...this.state, selectedProjectionId: value });
    } else if (key == "tickets") {
      this.setState({ ...this.state, tickets: value });
      console.log(this.state.tickets);
    } else if (key === "movie") {
      this.setState({ ...this.state, selectedMovieId: value });
    } else if (key === "numberOfTickets") {
      this.setState({ ...this.state, numberOfTickets: value });
    }
  }

  handleChange(date) {
    this.setState({
      ...this.state,
      selectedDate: date
    });
  }

  redirect() {
    this.setState({ ...this.state, redirect: true });
  }

  getProjections() {
    axios
      .get(projectionsEndpoint + "/get-projections")
      .then(response => {
        const projections = response.data;
        this.setState({ ...this.state, projections: projections });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error, projections: [] });
      });
  }

  getMovies() {}

  componentDidMount() {
    this.setState({
      ...this.state,
      reservationModalVisible: false,
      tickets: 1,
      projectionModalVisible: false,
      selectedDate: moment()
    });

    this.setState({ ...this.state, redirect: false });
    this.getProjections();
    axios
      .get(movieEndpoint + "/findAll")
      .then(response => {
        const movies = response.data;
        this.setState({ ...this.state, movies: movies });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  render() {
    const { projections, error, movies } = this.state;

    if (this.state.redirect) {
      return <Redirect to="/login" />;
    }

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <h3> Cinema projections </h3>
              <ProjectionsList
                redirect={this.redirect.bind(this)}
                projections={projections}
                error={error}
                movies={movies}
                showProjectionModal={this.showProjectionModal.bind(this)}
                showReservationModal={this.showReservationModal.bind(this)}
                hideProjectionModal={this.hideProjectionModal.bind(this)}
                hideReservationModal={this.hideReservationModal.bind(this)}
                saveProjection={this.saveProjection.bind(this)}
                updateForm={this.updateForm.bind(this)}
                handleChange={this.handleChange.bind(this)}
                tickets={this.state.tickets}
                numberOfTickets={this.state.numberOfTickets}
                selectedDate={this.state.selectedDate}
                selectedMovieId={this.state.selectedMovieId}
                selectedProjectionId={this.state.selectedProjectionId}
                reservationModalVisible={this.state.reservationModalVisible}
                projectionModalVisible={this.state.projectionModalVisible}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
