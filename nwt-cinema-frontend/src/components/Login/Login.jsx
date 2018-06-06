import React, { Component } from "react";
import {
  Button,
  Form,
  Grid,
  Header,
  Message,
  Segment,
  Loader,
  Dimmer,
  Label, 
  Icon
} from "semantic-ui-react";
import axios from "axios";
import { authEndpoint } from "../../endpoints";
import { Redirect } from "react-router-dom";

const API_ROUTE = authEndpoint + "/login";

export default class Login extends Component {
  state = {};
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      pass: "",
      authenticated: false,
      error: false,
      loading: false
    };

    this.updateState = this.updateState.bind(this);
  }
  componentWillMount() {
    this.setState({
      username: "",
      pass: "",
      authenticated: false,
      error: false,
      loading: false
    });
  }

  updateState(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  log(event) {
    this.setState({ ...this.state, loading: true });
    this.login(event);
  }

  login(event) {
    const data = {
      username: this.state.username,
      password: this.state.pass
    };

    console.log(this.state);
    axios
      .post(API_ROUTE, data)
      .then(response => {
        localStorage.setItem("token", response.headers["authorization"]);
        localStorage.setItem("role", response.headers["role"]);
        localStorage.setItem("username", this.state.username);

        // localStorage.setItem("user", response.headers["user"]);

        axios.defaults.headers["Authorization"] =
          response.headers["authorization"];
        this.setState({ authenticated: true });
        console.log("Logged in");
        this.setState({
          ...this.state,
          loggedin: true,
          loading: false
        });
      })
      .catch(err => {
        this.setState({
          ...this.state,
          loading: false,
          error: true
        });
      });
  }

  render() {
    if (this.state.loading) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading" />
        </Dimmer>
      );
    }
    if (this.state.loggedin) {
      return <Redirect to="/" />;
    }

    return (
      <div className="login-form">
        <style>{`
              body > div,
              body > div > div,
              body > div > div > div.login-form {
                height: 100%;
                }
    `}</style>
        <Grid
          textAlign="center"
          style={{ height: "100%" }}
          verticalAlign="middle"
        >
          <Grid.Column style={{ maxWidth: 450 }}>
            <Header as="h2" color="yellow" textAlign="center">
              {/*<Image src='/logo.png'/>*/} Log-in to your account
            </Header>
            <Form size="large">
              <Segment stacked>
                {this.state.error && (
                  <Label size="large" color="red">
                    <Icon name="warning" />
                    Wrong username or password{" "}
                  </Label>
                )}
                <Form.Input
                  fluid
                  icon="user"
                  iconPosition="left"
                  placeholder="Username"
                  name="username"
                  value={this.state.username}
                  onChange={this.updateState}
                />
                <Form.Input
                  fluid
                  icon="lock"
                  iconPosition="left"
                  placeholder="Password"
                  type="password"
                  name="pass"
                  value={this.state.pass}
                  onChange={this.updateState}
                />

                <Button
                  color="green"
                  fluid
                  size="large"
                  onClick={event => this.log(event)}
                >
                  Login
                </Button>
              </Segment>
            </Form>
            <Message>
              New to us? <a href="/sign-up">Sign Up</a>
            </Message>
          </Grid.Column>
        </Grid>
      </div>
    );
  }
}
