import React, { Component } from "react";
import { Divider, Icon, Message, Grid, Button } from "semantic-ui-react";
import axios from "axios";
import { movieEndpoint } from "../../endpoints";
import { Link } from "react-router-dom";

export default class AddMovieToDatabase extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      endStatus: ""
    };
  }

  componentWillMount() {
    axios
      .post(movieEndpoint + "/addMovie/" + this.props.match.params.id)
      .then(response => {
        this.setState({
          endStatus: response.request.status
        });
      })
      .catch(error => {
        this.setState({ error: error });
      });
  }


  render() {
    return (
      <Grid>
        <Grid.Row>
          <Grid.Column width={3} />
          <Grid.Column width={10}>
            <Link to="/search">
              <Button
                positive
                labelPosition="right"
                icon="search"
                content="Search and add movies"
              />
            </Link>
            <Link to="/movies">
              <Button
                primary
                labelPosition="right"
                icon="film"
                content="View movies"
              />
            </Link>
            <Divider hidden />
            {this.state.endStatus === 200 ? (
              <div className="ui success message">
                <i className="close icon" />
                <div className="header">Movie added!</div>
                <p>Now you can create projection for this movie.</p>
              </div>
            ) : (
              <Message negative size="huge">
                <Message.Header>
                  <Icon name="remove circle" />
                  We're sorry, error occurred
                </Message.Header>
              </Message>
            )}
          </Grid.Column>
          <Grid.Column width={3} />
        </Grid.Row>
      </Grid>
    );
  }
}
