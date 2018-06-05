import React, { Component } from "react";
import { Grid } from "semantic-ui-react";
import axios from "axios";
import { projectionsEndpoint } from "../../endpoints";
import Projection from "./Projection";
import moment from "moment";

export default class ProjectionScreen extends Component {
  constructor(props) {
    super(props);
    this.state = { projection: null, movie: null, error: null };
  }

  componentWillMount() {
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
            this.setState({ movie: movie });
          })
          .catch(error => {
            this.setState({ error: error });
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
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <Projection movie={movie} error={error} projection={projection} />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
