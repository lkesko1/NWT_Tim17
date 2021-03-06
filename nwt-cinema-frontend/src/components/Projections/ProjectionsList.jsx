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
import { projectionsEndpoint } from "../../endpoints";
import axios from "axios";

export default class ProjectionsList extends Component {
  showReservationModal(id) {
    this.props.showReservationModal(id);
  }

  getContent() {
    const { projections, error, role } = this.props;

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

    const isAdmin = role && role === "ROLE_ADMIN" ? true : false;
    const isUser = role && role === "ROLE_USER" ? true : false;

    let projectionsList = [];
    for (let currentProjection of projections) {
      const availableTickets =
        currentProjection.maxTickets - currentProjection.actualTickets;
      let reservationButton;

      if (isAdmin) {
        reservationButton = (
          <Link
            to={`/projection-reservations/${currentProjection.projectionID}`}
          >
            <Button
              key={currentProjection.projectionID}
              className="positive ui button"
              primary
              floated="right"
            >
              View reservations
              <Icon name="right chevron" />
            </Button>
          </Link>
        );
      } else {
        if (availableTickets > 0) {
          reservationButton = (
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
          );
        } else {
          reservationButton = (
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
          );
        }
      }
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
                      <b> Available tickets: </b> {availableTickets}{" "}
                    </List.Item>
                    <List.Item>
                      {" "}
                      <b> Max tickets: </b> {currentProjection.maxTickets}{" "}
                    </List.Item>
                  </List>
                </Item.Description>
                <Item.Extra>
                  {reservationButton}
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
    const { projections, error, movies, role } = this.props;

    const isAdmin = role && role === "ROLE_ADMIN" ? true : false;
    const isUser = role && role === "ROLE_USER" ? true : false;

    if (!projections && !error) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading" />
        </Dimmer>
      );
    }

    return (
      <div>
        <NewReservationModal
          reservationModalVisible={this.props.reservationModalVisible}
          hideReservationModal={this.props.hideReservationModal}
          projections={projections}
          selectedProjectionId={this.props.selectedProjectionId}
          updateForm={this.props.updateForm}
          tickets={this.props.tickets}
          confirm={this.props.confirm}
          success={this.props.success}
          fail={this.props.fail}
        />
        <ProjectionModal
          projectionModalVisible={this.props.projectionModalVisible}
          hideProjectionModal={this.props.hideProjectionModal}
          movies={movies}
          selectedDate={this.props.selectedDate}
          updateForm={this.props.updateForm}
          numberOfTickets={this.props.numberOfTickets}
          handleChange={this.props.handleChange}
          selectedMovieId={this.props.selectedMovieId}
          saveProjection={this.props.saveProjection}
        />
        {isAdmin && (
          <Button
            positive
            labelPosition="right"
            icon="add"
            content="Add new projection"
            onClick={this.props.showProjectionModal}
          />
        )}
        {this.getContent()}
      </div>
    );
  }
}
