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
import { projectionsEndpoint } from "../../endpoints";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export class ProjectionModal extends Component {
  saveProjection() {
    const {
      selectedMovieId,
      hideProjectionModal,
      selectedDate,
      numberOfTickets,
    } = this.props;

    axios
      .post(projectionsEndpoint + "/movietimetable/create", {
        movieID: selectedMovieId,
        createdBy: 1,
        date: selectedDate,
        actualTickets: numberOfTickets,
        maxTickets: numberOfTickets
      })
      .then(response => {
        console.log(response);
        hideProjectionModal();
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    const {
      projectionModalVisible,
      hideProjectionModal,
      movies,
      updateForm,
      selectedDate,
      handleChange
    } = this.props;

    let index = 0;

    const movieNames = _.map(movies, movie => {
      index = index + 1;
      return {
        key: index,
        value: index,
        text: movie.Title
      };
    });

    let value = index;
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
                  value={value}
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
                  defaultValue={100}
                  onChange={e => {
                    updateForm(e, "tickets", e.target.value);
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
              onClick={this.saveProjection.bind(this)}
            />
          </Modal.Actions>
        </Modal>
      </div>
    );
  }
}
