import React, { Component } from "react";
import {
  Button,
  Form,
  Grid,
  Header,
  Message,
  Segment
} from "semantic-ui-react";
import axios from "axios";
import { authEndpoint } from "../../endpoints";

const API_ROUTE = authEndpoint + "/login";

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      pass: "",
      authenticated: false
    };

    this.updateState = this.updateState.bind(this);
  }

  updateState(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  login(event) {
    console.log(this.state);
    const data = {
      username: this.state.username,
      password: this.state.pass
    };

    axios
      .post(API_ROUTE, data)
      .then(response => {
        localStorage.setItem("token", response.headers["authorization"]);
        axios.defaults.headers["Authorization"] =
          response.headers["authorization"];
        this.setState({ authenticated: true });
      })
      .catch(function(error) {
        console.log(error);
      });
  }

  render() {
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
                  onClick={event => this.login(event)}
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
