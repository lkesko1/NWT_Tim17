import React, { Component } from "react";
import {
  BrowserRouter as Router,
  Route
} from "react-router-dom";
import Home from "./components/Home/index.jsx";
import Content from "./components/Content";
import MoviesScreen from "./components/Movies/MoviesScreen";
import MovieScreen from "./components/Movies/MovieScreen";
import AboutUs from "./components/AboutUs/AboutUs";
import ProjectionsScreen from "./components/Projections/ProjectionsScreen";
import ProjectionScreen from "./components/Projections/ProjectionScreen";
import Search from "./components/SearchMovies/Search";
import SearchMovieScreen from "./components/SearchMovies/SearchMovieScreen";
import AddMovieToDatabase from "./components/SearchMovies/AddMovieToDatabase";
import Login from "./components/Login/Login";
import SignUp from "./components/SignUp/SignUp";
import axios from "axios";

class App extends Component {
  componentDidMount() {
    let token = localStorage.getItem("token");
    if (token) {
      axios.defaults.headers['Authorization'] = token;
    }
    console.log('axios defaults', axios.defaults)
  }

  render() {
    return (
      <Router >
        <div>
          <Content>
            <Route exact path={"/"} component={Home}/>
              <Route exact path="/movies" component={MoviesScreen} />
              <Route exact path="/movies/:id" component={MovieScreen} />
              <Route exact path={"/projections"} component={ProjectionsScreen} />
              <Route exact path="/projections/:id" component={ProjectionScreen} />
              <Route exact path={"/about-us"} component={AboutUs} />
              <Route exact path={"/contact"} component={Home} />
              <Route exact path={"/search"} component={Search} />
              <Route exact path={"/search/:id"} component={SearchMovieScreen} />
              <Route exact path={"/add-movie/:id"} component={AddMovieToDatabase}/>
              <Route exact path={"/login"} component={Login}/>
              <Route exact path={"/sign-up"} component={SignUp}/>
          </Content>
        </div>
      </Router>
    );
  }
}

export default App;
