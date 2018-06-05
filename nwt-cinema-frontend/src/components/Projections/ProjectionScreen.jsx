import React, { Component } from "react";
import { Grid } from "semantic-ui-react";
import axios from "axios";
import { projectionsEndpoint } from "../../endpoints";
import Projection from "./Projection";
import { RemovalModal } from "./RemovalModal";

export default class ProjectionScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      movie: null,
      error: null,
      removalModalVisible: false
    };
  }

  showRemovalModal() {
    this.setState({
      ...this.state,
      removalModalVisible: true
    });
  }

  hideRemovalModal() {
    this.setState({
      ...this.state,
      removalModalVisible: false
    });
  }

  removeMovie() {
    this.hideRemovalModal();
    console.log("delete movie");
  }

  componentWillMount() {
    axios
      .get(projectionsEndpoint + "/get-details/" + this.props.match.params.id)
      .then(response => {
        const movie = response.data;
        this.setState({ movie: movie });
      })
      .catch(error => {
        this.setState({ error: error });
      });
  }

  render() {
    const { movie, error } = this.state;

    return (
      <div>
        <RemovalModal
          deleteModalVisible={this.state.removalModalVisible}
          hideRemovalModal={this.hideRemovalModal.bind(this)}
          removeMovie={this.removeMovie.bind(this)}
        />
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Projection
                movie={movie}
                error={error}
                showRemovalModal={this.showRemovalModal.bind(this)}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
