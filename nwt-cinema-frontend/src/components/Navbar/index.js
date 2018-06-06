import React, { Component } from "react";
import { Segment, Button, Menu, Icon, Image } from "semantic-ui-react";
import logo from "../../images/movie-time.png";
import { Link } from "react-router-dom";
import axios from "axios";

export default class Navbar extends Component {
  state = {};
  handleItemClick = (e, { name }) => {
    this.setState({ ...this.state, activeItem: "hom" });
  };

  logout() {
    localStorage.removeItem("role");
    localStorage.removeItem("token");
    this.setState({
      activeItem: "logout",
      redirect: true
    });
    this.props.logged(false);
  }

  render() {
    let { activeItem } = this.state;

    if (!activeItem) {
      activeItem = this.props.activeItem.substring(1);
      if (!activeItem) activeItem = "home";
    }

    const userAuthenticated =
      axios.defaults.headers.Authorization && localStorage.getItem("token")
        ? true
        : false;

    return (
      <Segment vertical>
        <Menu inverted fixed="top" size="small">
          <Menu.Item>
            <Image size="tiny" src={logo} alt="logo" />
          </Menu.Item>
          <Menu.Item
            as={Link}
            to="/"
            name="home"
            active={activeItem === "home"}
            onClick={this.handleItemClick}
          >
            <Icon name="home" />
            Home
          </Menu.Item>
          <Menu.Item
            as={Link}
            to="/movies"
            name="movies"
            active={activeItem === "movies"}
            onClick={this.handleItemClick}
          >
            <Icon name="film" /> Movies{" "}
          </Menu.Item>
          <Menu.Item
            as={Link}
            to="/projections"
            name="projections"
            active={activeItem === "projections"}
            onClick={this.handleItemClick}
          >
            <Icon name="video camera" /> Projections{" "}
          </Menu.Item>
          <Menu.Item
            as={Link}
            to="/about-us"
            name="about"
            active={activeItem === "about"}
            onClick={this.handleItemClick}
          >
            <Icon name="question" />About us{" "}
          </Menu.Item>
          <Menu.Item
            name="contact"
            active={activeItem === "contact"}
            onClick={this.handleItemClick}
          >
            <Icon name="phone" /> Contact{" "}
          </Menu.Item>
          {userAuthenticated &&
            localStorage.getItem("role") === "ROLE_USER" && (
              <Menu.Item
                name="reservations"
                active={activeItem === "reservations"}
                as={Link} 
                to={`/user-reservations/${2}`}
                onClick={this.handleItemClick}
                color="yellow"
              >
                <Icon name="ticket" color="yellow" /> My reservations
              </Menu.Item>
            )}

          <Menu.Item position="right">
            {!userAuthenticated ? (
              <div>
                <Button as={Link} to="/login" inverted>
                  Log in
                </Button>
                <Button
                  as={Link}
                  to="/sign-up"
                  inverted
                  primary
                  style={{ marginLeft: "0.5em" }}
                >
                  Sign Up
                </Button>
              </div>
            ) : (
              <div>
                <Link to="/">
                  <Icon name="user" size="large" inverted />
                </Link>
                <Button
                  as={Link}
                  to="/login"
                  inverted
                  onClick={this.logout.bind(this)}
                >
                  Log out
                </Button>
              </div>
            )}
          </Menu.Item>
        </Menu>
      </Segment>
    );
  }
}
