import React, { Component } from "react";
import { Segment, Button, Menu, Icon, Image } from "semantic-ui-react";
import logo from "../../images/movie-time.png";
import { Link } from "react-router-dom";

export default class Navbar extends Component {
  state = {}

  handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
    const { activeItem } = this.state

    if (!activeItem) {
    }

    return (
      <Segment vertical>
        <Menu inverted fixed="top" size="small">
          <Menu.Item>
            <Image size="tiny" src={logo} alt="logo" />
          </Menu.Item>
          <Menu.Item name="home" active={activeItem === 'home'} onClick={this.handleItemClick}>
            <Link to="/">
              <Icon name="home" />
              Home
            </Link>
          </Menu.Item>
          <Menu.Item name="movies" active={activeItem === 'movies'} onClick={this.handleItemClick}>
            <Link to="/movies">
              <Icon name="film" /> Movies{" "}
            </Link>
          </Menu.Item>
          <Menu.Item name="projections"  active={activeItem === 'projections'} onClick={this.handleItemClick}>
            <Link to="/projections">
            <Icon name="video camera" /> Projections{" "}
            </Link>
          </Menu.Item>
          <Menu.Item name="about" active={activeItem === 'about'} onClick={this.handleItemClick}>
            <Link to="/about-us">
            <Icon name="question" />About us{" "}
            </Link>
          </Menu.Item>
          <Menu.Item name="contact" active={activeItem === 'contact'} onClick={this.handleItemClick}>
            <Icon name="phone" /> Contact{" "}
          </Menu.Item>

          <Menu.Item position="right">
            <Button inverted>Log in</Button>
            <Button inverted primary style={{ marginLeft: "0.5em" }}>
              Sign Up
            </Button>
          </Menu.Item>
        </Menu>
      </Segment>
    );
  }
}
