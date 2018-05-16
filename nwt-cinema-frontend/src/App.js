import React, { Component } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { Route } from "react-router-dom";
import Home from "./components/Home/index.jsx";
import Content from "./components/Content/index.js";

class App extends Component {
  render() {
    return (
      <Router>
        <Route path="/" Component={Content}>
          <Route exact path="/" component={Home} />
        </Route>
      </Router>
    );
  }
}

export default App;
