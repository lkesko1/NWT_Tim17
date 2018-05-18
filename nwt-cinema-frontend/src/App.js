import React, { Component } from "react";
import {
  BrowserRouter as Router,
  Route,
  BrowserRouter
} from "react-router-dom";
import Home from "./components/Home/index.jsx";
import Content from "./components/Content";
import MoviesScreen from "./components/Movies/MoviesScreen";
import MovieScreen from "./components/Movies/MovieScreen";

class App extends Component {
  render() {
    return (
      <Router >
        <div>
          <Content>
            <Route exact path={"/"} component={Home}/>
              <Route exact path="/movies" component={MoviesScreen} />
              <Route exact path="/movies/:id" component={MovieScreen} />
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
