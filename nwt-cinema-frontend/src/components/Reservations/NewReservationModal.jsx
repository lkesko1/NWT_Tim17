import React, { Component } from "react";
import {
  Label,
  Modal,
  Button,
  Image,
  Dropdown,
  Form,
  Divider,
  List
} from "semantic-ui-react";
import _ from "lodash";

export class NewReservationModal extends Component {
  render() {
    const {
      reservationModalVisible,
      hideReservationModal,
      saveReservation,
      projections,
      selectedProjection,
      changeSelectedProjection,
      updateNumberOfTickets
    } = this.props;

    const projectionNames = _.map(projections, projection => {
      return {
        key: projection.projectionID,
        value: projection.projectionID,
        text: projection.title
      };
    });

    console.log(selectedProjection);
    return (
      <Modal open={reservationModalVisible} onClose={hideReservationModal}>
        <Modal.Header>Make a reservation</Modal.Header>
        <Modal.Content>
          <Dropdown
            placeholder="Select movie"
            fluid
            search
            selection
            options={projectionNames}
            onChange={e => {
              changeSelectedProjection(e);
            }}
          />

          <Divider clearing />

          <Label color="blue" ribbon>
            Selected movie projection:
          </Label>
          <Divider hidden />

          <List>
         
          </List>

          <Divider clearing />

          <Form>
            <Form.Field required>
              <label> Number of tickets </label>
              <input

                type="number"
                defaultValue={1}
                onChange={e => {
                  updateNumberOfTickets(e);
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
            onClick={saveReservation}
          />
        </Modal.Actions>
      </Modal>
    );
  }
}
