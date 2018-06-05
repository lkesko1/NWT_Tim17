import React, { Component } from "react";
import "./style.css";
import { Grid, Button, Header, Image } from "semantic-ui-react";
import jumbotronImage from "../../images/DMOHA20140112005.jpg";
import logo from "../../images/movie-time.png";
import { Link } from "react-router-dom";

export let role;

export default class Home extends Component {
  state = {};

  componentWillMount() {
    role = localStorage.getItem("role");
  }
  componentDidMount() {
    this.setState({
      ...this.state,
      token: localStorage.getItem("token")
    });
  }

  render() {
    const isLogged = this.state.token ? true : false;
    console.log(isLogged);

    return (
      <Grid container stackable verticalAlign="middle">
        <Grid.Row>
          <Grid.Column width={8} textAlign="center">
            <Image centered src={logo} size="small" />
            <Header as="h2">Reserve movie tickets and rate movies</Header>
            <p style={{ fontSize: "1.2em" }}>
              Buying movie tickets early can ensure that you get a seat at a
              crowded premiere or even get you a better seat. Book your seat on
              time.
            </p>
            {isLogged ? (
              <Link to="/projections">
                <Button
                  primary
                  content="View projections"
                  icon="video"
                  labelPosition="left"
                  size="huge"
                />
              </Link>
            ) : (
              <Link to="sign-up">
                <Button
                  primary
                  content="Sign up now"
                  icon="sign in"
                  labelPosition="left"
                  size="huge"
                />
              </Link>
            )}
          </Grid.Column>
          <Grid.Column width={8} textAlign="center">
            <Image src={jumbotronImage} />
          </Grid.Column>
        </Grid.Row>
      </Grid>
    );
  }
}
