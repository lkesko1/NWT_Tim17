import React, { Component } from "react";
import {
  Item,
  Icon,
  Button,
  Segment,
  List,
  Message,
  Label,
  Dimmer, 
  Loader
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import { Link } from "react-router-dom";
import { NewReservationModal } from "../Reservations/NewReservationModal";
import { ProjectionModal } from "./ProjectionModal";
import moment from "moment";

export default class ProjectionsList extends Component {
  componentDidMount() {
    this.setState({
      reservationModalVisible: false,
      tickets: 1,
      projectionModalVisible: false,
      selectedDate: moment()
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
    console.log("key:", key, "value: ", value);

    if (key == "projection") {
      this.setState({ ...this.state, selectedProjectionId: value });
    } else if (key == "tickets") {
      this.setState({ ...this.state, tickets: value });
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
      selectedMovieId: this.props.movies[0].id,
      numberOfTickets: 100
    });
  }

  getContent() {
    const { projections } = this.props;
    let projectionsList = [];

    for (let currentProjection of projections) {
      const content = (
        <Segment key={currentProjection.projectionID} color="yellow">
          <Item.Group divided>
            <Item>
              <Item.Image style={{ marginTop: 20 }} size="small" src={logo} />

              <Item.Content>
                <Item.Header>{currentProjection.title}</Item.Header>
                <Item.Description>
                  <List>
                    <List.Item>
                      {" "}
                      <b> Genre: </b> {currentProjection.genre}{" "}
                    </List.Item>
                    <List.Item>
                      {" "}
                      <b> Available tickets: </b>{" "}
                      {currentProjection.actualTickets}{" "}
                    </List.Item>
                    <List.Item>
                      {" "}
                      <b> Max tickets: </b> {currentProjection.maxTickets}{" "}
                    </List.Item>
                  </List>
                </Item.Description>
                <Item.Extra>
                  <Link to="/projections">
                    <Button
                      key={currentProjection.projectionID}
                      className="positive ui button"
                      primary
                      floated="right"
                      onClick={this.showReservationModal.bind(
                        this,
                        currentProjection.projectionID
                      )}
                    >
                      Make a reservation
                      <Icon name="right chevron" />
                    </Button>
                  </Link>
                  <Link to={"/projections/" + currentProjection.projectionID}>
                    <Button primary floated="right">
                      View more
                      <Icon name="right chevron" />
                    </Button>
                  </Link>
                  <Label color="red">
                    {" "}
                    Date: {moment(currentProjection.date).format("YYYY-MM-DD")}
                  </Label>

                  <Label color="red">
                    Time: {moment(currentProjection.date).format("HH:mm:ss")}
                  </Label>
                </Item.Extra>
              </Item.Content>
            </Item>
          </Item.Group>
        </Segment>
      );

      projectionsList.push(content);
    }
    return projectionsList;
  }

  render() {
    const { projections, error, movies } = this.props;

    if (!projections && !error) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading" />
        </Dimmer>
      );
    }

    if (projections.length === 0 || error) {
      return (
        <Message negative size="huge">
          <Message.Header>
            <Icon name="remove circle" />
            We're sorry we can't find projections in database!
          </Message.Header>
        </Message>
      );
    }

    const role = localStorage.getItem("role");
    const isAdmin = role && role === "ROLE_ADMIN" ? true : false;

    return (
      <div>
        <NewReservationModal
          reservationModalVisible={this.state.reservationModalVisible}
          hideReservationModal={this.hideReservationModal.bind(this)}
          projections={projections}
          selectedProjectionId={this.state.selectedProjectionId}
          updateForm={this.updateForm.bind(this)}
          tickets={this.state.tickets}
        />
        <ProjectionModal
          projectionModalVisible={this.state.projectionModalVisible}
          hideProjectionModal={this.hideProjectionModal.bind(this)}
          movies={movies}
          selectedDate={this.state.selectedDate}
          updateForm={this.updateForm.bind(this)}
          numberOfTickets={this.state.numberOfTickets}
          handleChange={this.handleChange.bind(this)}
          selectedMovieId={this.state.selectedMovieId}
        />
        {isAdmin && (
          <Button
            positive
            labelPosition="right"
            icon="add"
            content="Add new projection"
            onClick={this.showProjectionModal.bind(this)}
          />
        )}
        {this.getContent()}
      </div>
    );
  }
}
