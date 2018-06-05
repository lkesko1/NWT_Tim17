import React, { Component } from "react";
import Navbar from "../Navbar";
import Footer from "../Footer";
import { Segment } from "semantic-ui-react";

export default class Content extends Component {
    state = {}

  componentWillMount() {
    const logged = localStorage.getItem("token") ? true : false; 
    this.setState({
      ...this.state,
      islogged: logged
    })
  }
  
  logged(islogged) {
    this.setState({
      ...this.state,
      islogged: islogged
    });
  }
  render() {
    console.log("OK", this.state.islogged);
    return (
      <div>
        <Navbar
          activeItem={this.props.history.location.pathname}
          logged={this.logged.bind(this)}
          islogged={this.state.islogged}
        />
        <Segment style={{ minHeight: 600, padding: "8em 0em" }} vertical>
          {this.props.children}
        </Segment>
        <Footer />
      </div>
    );
  }
}
