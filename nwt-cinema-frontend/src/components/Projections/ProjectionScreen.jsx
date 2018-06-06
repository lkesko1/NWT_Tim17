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
    axios
      .delete(projectionsEndpoint + "/delete/" + this.props.match.params.id)
      .then(response => {
        this.hideRemovalModal();
        this.setState({ ...this.state, projection: null, loading: false });
        this.getProjection();
      })
      .catch(error => {
        this.setState({ ...this.state, error: error, });
      });
  }


  componentDidMount() {
    this.getProjection();
  }

  getProjection() {
    axios
      .get(projectionsEndpoint + "/" + this.props.match.params.id)
      .then(response => {
        const projection = response.data;
        this.setState({ ...this.state, projection: projection });
        axios
          .get(
            projectionsEndpoint +
              "/get-details/" +
              this.state.projection.movieID
          )
          .then(response => {
            let movie = response.data;
            this.setState({ ...this.state, movie: movie });
          })
          .catch(error => {
            this.setState({ ...this.state, error: error });
          });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  render() {
    const { movie, error, projection } = this.state;

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
                projection={projection}
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
