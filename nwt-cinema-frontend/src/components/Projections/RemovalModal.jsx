import React, { Component } from "react";
import { Modal, Button, Header } from "semantic-ui-react";

export class RemovalModal extends Component {
  render() {
    const {
      deleteModalVisible,
      hideRemovalModal,
      removeMovie,
      type
    } = this.props;
    return (
      <Modal basic open={deleteModalVisible} onClose={hideRemovalModal}>
        <Header icon="trash" content="Delete projection?" />
        <Modal.Content>
          <p>Are you sure?</p>
        </Modal.Content>
        <Modal.Actions>
          <Button negative content="Cancel" onClick={hideRemovalModal} />

          <Button positive content="OK" onClick={removeMovie} />
        </Modal.Actions>
      </Modal>
    );
  }
}
