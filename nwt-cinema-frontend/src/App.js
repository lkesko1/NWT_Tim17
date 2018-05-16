import React, { Component } from "react";
import {
  BrowserRouter as Router,
  Route,
  BrowserRouter
} from "react-router-dom";
import Home from "./components/Home/index.jsx";
import Content from "./components/Content";

class App extends Component {
  render() {
    return (
      <Router history={BrowserRouter}>
        <div>
          <Content>
            <Route exact path={"/"} component={Home} />
            <Route exact path={"/movies"} component={Home} />
            <Route exact path={"/projections"} component={Home} />
            <Route exact path={"/aboutUs"} component={Home} />
            <Route exact path={"/contact"} component={Home} />
          </Content>
        </div>
      </Router>
    );
  }
}

export default App;
