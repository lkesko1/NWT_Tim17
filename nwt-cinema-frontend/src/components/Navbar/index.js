import React, { Component } from "react";
import { Button, Menu, Item, Divider, Container } from "semantic-ui-react";
import logo from "../../images/movie-time-cinema-logo-8B5BE91828-seeklogo.com.png";

export default class Navbar extends Component {
  render() {
    return (
      <div>
        <Menu inverted secondary size="large">
            <Item>
              <Item.Image size="small" src={logo} alt="logo" />
            </Item>
            <Menu.Item as="a" active>
              Home
            </Menu.Item>
            <Menu.Item as="a"> Movies </Menu.Item>
            <Menu.Item as="a"> Projections </Menu.Item>
            <Menu.Item as="a"> About us </Menu.Item>
            <Menu.Item as="a"> Contact </Menu.Item>

            <Menu.Item position="right">
              <Button as="a" inverted>
                Log in
              </Button>
              <Button as="a" inverted primary style={{ marginLeft: "0.5em" }}>
                Sign Up
              </Button>
            </Menu.Item>
        </Menu>
        <Divider />
      </div>
    );
  }
}
