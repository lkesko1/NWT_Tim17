import React, { Component } from "react";
import { Segment, Button, Menu, Icon, Image } from "semantic-ui-react";
import logo from "../../images/movie-time.png";
import { Link } from "react-router-dom";

export default class Navbar extends Component {
  render() {
    return (
      <Segment vertical>
        <Menu inverted fixed="top" size="small">
          <Menu.Item>
            <Image size="tiny" src={logo} alt="logo" />
          </Menu.Item>
          <Menu.Item as="a" active>
            <Link to="/">
              <Icon name="home" />
              Home
            </Link>
          </Menu.Item>
          <Menu.Item as="a">
            <Link to="/movies">
              <Icon name="film" /> Movies{" "}
            </Link>
          </Menu.Item>
          <Menu.Item as="a">
            <Icon name="video camera" /> Projections{" "}
          </Menu.Item>
          <Menu.Item as="a">
            <Icon name="question" />About us{" "}
          </Menu.Item>
          <Menu.Item as="a">
            <Icon name="phone" /> Contact{" "}
          </Menu.Item>

          <Menu.Item position="right">
            <Button as="a" inverted>
              Log in
            </Button>
            <Button as="a" inverted primary style={{ marginLeft: "0.5em" }}>
              Sign Up
            </Button>
          </Menu.Item>
        </Menu>
      </Segment>
    );
  }
}
