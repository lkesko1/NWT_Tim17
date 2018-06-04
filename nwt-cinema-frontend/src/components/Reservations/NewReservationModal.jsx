import React, { Component } from "react";
import {
  Label,
  Modal,
  Button,
  Dropdown,
  Form,
  Divider,
  Image,
  List,
  Grid,
  Segment,
  Icon
} from "semantic-ui-react";
import _ from "lodash";
import axios from "axios";
import { projectionsEndpoint } from "../../endpoints";
import moment from "moment";

export class NewReservationModal extends Component {
  saveReservation() {
    const { selectedProjectionId, tickets, hideReservationModal } = this.props;

    axios
      .post(projectionsEndpoint + "/reservations/create", {
        numberOfTickets: tickets,
        userId: 1,
        movieProjectionId: selectedProjectionId
      })
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        console.log(error);
      });

    hideReservationModal();
  }

  render() {
    const {
      reservationModalVisible,
      hideReservationModal,
      projections,
      selectedProjectionId,
      updateForm
    } = this.props;

    const projectionNames = _.map(projections, projection => {
      return {
        key: projection.projectionID,
        value: projection.projectionID,
        text: projection.title
      };
    });

    if (selectedProjectionId) {
      let value = selectedProjectionId ? selectedProjectionId : 0;
      const selectedProjection = _.find(projections, projection => {
        return projection.projectionID === selectedProjectionId;
      });
      const date = moment(selectedProjection.date).format(
        "YYYY-MM-DD HH:mm:ss"
      );

      return (
        <Modal
          size="small"
          open={reservationModalVisible}
          onClose={hideReservationModal}
        >
          <Modal.Header>
            {" "}
            <Icon name="ticket" /> Make a reservation
          </Modal.Header>
          <Modal.Content>
            <Label color="blue" ribbon>
              Selected movie projection:
            </Label>

            {selectedProjection != null ? (
              <Segment color="blue">
                <List size="large">
                  <Grid width={16}>
                    <Grid.Column width={6}>
                      <Image
                        centered
                        size="small"
                        src={require("../../images/cinema (1).png")}
                      />
                    </Grid.Column>
                    <Grid.Column width={8}>
                      <List.Item>
                        {" "}
                        <b> Title: </b>
                        {selectedProjection.title}{" "}
                      </List.Item>
                      <List.Item>
                        {" "}
                        <b> Genre: </b> {selectedProjection.genre}{" "}
                      </List.Item>
                      <List.Item>
                        {" "}
                        <b> Date: </b>
                        {date}
                      </List.Item>
                      <List.Item>
                        {" "}
                        <b> Number of tickets </b>{" "}
                        {selectedProjection.actualTickets}{" "}
                      </List.Item>
                    </Grid.Column>
                  </Grid>
                </List>
              </Segment>
            ) : (
              <div> </div>
            )}

            <label> Select movie: </label>
            <Dropdown
              placeholder="Select movie"
              fluid
              search
              selection
              options={projectionNames}
              value={value}
              onChange={(e, { value }) => {
                updateForm(e, "projection", value);
              }}
            />

            <Divider hidden />
            <Form>
              <Form.Field required>
                <label> Number of tickets </label>
                <input
                  type="number"
                  min={1}
                  max={
                    selectedProjection ? selectedProjection.actualTickets : 50
                  }
                  defaultValue={1}
                  onChange={e => {
                    updateForm(e, "tickets", e.target.value);
                  }}
                />
              </Form.Field>
            </Form>
          </Modal.Content>
          <Modal.Actions>
            <Button color="black" onClick={hideReservationModal}>
              Close
            </Button>
            <Button
              positive
              icon="checkmark"
              labelPosition="right"
              content="Send"
              onClick={this.saveReservation.bind(this)}
            />
          </Modal.Actions>
        </Modal>
      );
    }
    return <div />;
  }
}
