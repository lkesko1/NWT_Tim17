import React, { Component } from "react";
import {
  Modal,
  Button,
  Dropdown,
  Form,
  Divider,
  Icon,
} from "semantic-ui-react";
import _ from "lodash";
import axios from "axios";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export class ProjectionModal extends Component {
  render() {
    const {
      projectionModalVisible,
      hideProjectionModal,
      movies,
      updateForm,
      selectedMovieId,
      selectedDate,
      handleChange,
      saveProjection
    } = this.props;

    console.log(projectionModalVisible);
    const movieNames = _.map(movies, movie => {
      return {
        key: movie.id,
        value: movie.id,
        text: movie.title
      };
    });

    const value = movieNames.length > 0 ? movieNames[0].key : 0;
    return (
      <div>
        <Modal
          size="small"
          open={projectionModalVisible}
          onClose={hideProjectionModal}
        >
          <Modal.Header>
            <Icon name="film" /> Add new projection
          </Modal.Header>
          <Modal.Content>
            <Form>
              <Form.Field required>
                <label> Select movie: </label>
                <Dropdown
                  placeholder="Select movie"
                  fluid
                  search
                  selection
                  options={movieNames}
                  default={value}
                  onChange={(e, { value }) => {
                    updateForm(e, "movie", value);
                  }}
                />
              </Form.Field>

              <Divider hidden />
              <Form.Field required>
                <label> Number of tickets </label>
                <input
                  type="number"
                  min={1}
                  max={1000}
                  defaultValue={this.props.numberOfTickets}
                  onChange={e => {
                    updateForm(e, "numberOfTickets", e.target.value);
                  }}
                />
              </Form.Field>
              <Form.Field required>
                <label> Select date: </label>
                <DatePicker selected={selectedDate} onChange={handleChange} />
              </Form.Field>
            </Form>
          </Modal.Content>
          <Modal.Actions>
            <Button color="black" onClick={hideProjectionModal}>
              Close
            </Button>
            <Button
              positive
              icon="checkmark"
              labelPosition="right"
              content="Send"
              onClick={saveProjection}
            />
          </Modal.Actions>
        </Modal>
      </div>
    );
  }
}
