import React, { Component } from "react";
import ProjectionsList from "./ProjectionsList";
import { Grid } from "semantic-ui-react";
import axios from "axios";
import { projectionsEndpoint, movieEndpoint } from "../../endpoints";

export default class ProjectionsScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      projections: [],
      error: null,
      movies: []
      
    };
  }

  componentWillMount() {
    axios
      .get(projectionsEndpoint + "/get-projections")
      .then(response => {
        const projections = response.data;
        this.setState({ ...this.state, projections: projections });
      })
      .catch(error => {
        this.setState({ error: error });
      });

    axios
      .get(movieEndpoint + "/findAll")
      .then(response => {
        const movies = response.data;
        this.setState({ ...this.state, movies: movies });
      })
      .catch(error => {
        this.setState({ ...this.state, error: error });
      });
  }

  render() {
    const { projections, error, movies } = this.state;

    return (
      <div>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3} />
            <Grid.Column width={10}>
              <ProjectionsList
                projections={projections}
                error={error}
                movies={movies}
              />
            </Grid.Column>
            <Grid.Column width={3} />
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
