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
import {Link} from "react-router-dom";

export class MovieModal extends Component {
  render() {
    const {
      showModal,
      closeModal,
      updateForm,
      modalVisible,
      movie
    } = this.props;

    return (
      <Modal size="small" open={modalVisible} onClose={closeModal}>
        <Modal.Header>
          <Icon name="ticket" /> Add youtube link for movie: {movie.Title}
        </Modal.Header>
        <Modal.Content>
          <Form>
            <Form.Field required>
              <label> YoutubeLink </label>
              <input
                onChange={e => {
                  updateForm(e, "youtube", e.target.value);
                }}
              />
            </Form.Field>
          </Form>
        </Modal.Content>
        <Modal.Actions>
          <Button color="black" onClick={closeModal}>
            Close
          </Button>
          <Link to={"/add-movie/" + movie.imdbID}>
            <Button
              positive
              icon="checkmark"
              labelPosition="right"
              content="Send"
            />
          </Link>
        </Modal.Actions>
      </Modal>
    );
  }
}
