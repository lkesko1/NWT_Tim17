import React, { Component } from "react";
import logo from "../../logo.svg";
import "./style.css";
import Navbar from "../Navbar";
import Footer from "../Footer";
import Jumbotron from "../Jumbotron";
import { Segment, Grid, Rail, Item, Header, Image } from "semantic-ui-react";

export default class Home extends Component {
  render() {
    return (
      <div>
        <Segment
          inverted
          textAlign="center"
          style={{ minHeight: 700, padding: "1em 0em" }}
          vertical
        >
          <Navbar />
          <Jumbotron />

        </Segment>
        <Footer /> 
        
      </div>
    );
  }
}
