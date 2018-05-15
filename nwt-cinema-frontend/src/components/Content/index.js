import React, { Component } from "react";

export default class Content extends Component {
  render() {
    console.log("NESTO")
    return <div>
    nestooo
    {this.props.children}</div>;
  }
}
