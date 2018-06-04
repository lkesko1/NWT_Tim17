import React, { Component } from "react";
import "./style.css";
import { Grid, Button, Header, Image } from "semantic-ui-react";
import jumbotronImage from "../../images/DMOHA20140112005.jpg";
import logo from "../../images/movie-time.png"

export let role;

export default class Home extends Component {
  state = {};

  componentWillMount(){
    role = localStorage.getItem("role");
  }
  
  render() {
    return (
      
        <Grid container stackable verticalAlign="middle">
          <Grid.Row>
            <Grid.Column width={8} textAlign="center">
            <Image centered src={logo} size='small'/>
              <Header as="h2">Reserve movie tickets and rate movies</Header>
              <p style={{ fontSize: "1.2em" }}>
                Buying movie tickets early can ensure that you get a seat at a
                crowded premiere or even get you a better seat. Book your seat on time.
              </p>

              <Button
                primary
                content="Sign up now"
                icon="sign in"
                labelPosition="left"
                size="huge"
              />
            </Grid.Column>
            <Grid.Column width={8} textAlign="center">
            <Image src={jumbotronImage} />
            
            </Grid.Column>
            
          </Grid.Row>

        </Grid>
    );
  }
}
