import React, { Component } from "react";
import { List, Segment, Container, Header, Grid, Divider } from "semantic-ui-react";
import logo from "../../images/movie-time-cinema-logo-8B5BE91828-seeklogo.com.png";

export default class Footer extends Component {
  render() {
    return (
      <Segment inverted vertical >
      <Divider />
      
        <Container>
          <Grid divided inverted stackable>
            <Grid.Row>
              <Grid.Column width={3}>
                <Header inverted as="h4" content="About" />
                <List link inverted>

                </List>
              </Grid.Column>
              <Grid.Column width={3}>
                <Header inverted as="h4" content="Services" />
                <List link inverted>
                  
                </List>
              </Grid.Column>
              <Grid.Column width={7}>
                <Header as="h4" inverted>
                  Contact
                </Header>
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </Container>
      </Segment>
    );
  }
}
