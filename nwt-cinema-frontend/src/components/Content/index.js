import React, { Component } from "react";
import Navbar from "../Navbar";
import Footer from "../Footer";
import {Segment} from "semantic-ui-react";

export default class Content extends Component {
  render() {
    return (
      <div>
        <Navbar activeItem={this.props.history.location.pathname}/>
        <Segment style={{ minHeight: 600, padding: "8em 0em" }} vertical>
          {this.props.children}
        </Segment>
        <Footer />
      </div>
    );
  }
}
