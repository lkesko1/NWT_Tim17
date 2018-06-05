import React, { Component } from "react";
import {
  Segment,
  Container,
  Icon
} from "semantic-ui-react";

export default class Footer extends Component {
  render() {
    return (
      <Segment inverted vertical textAlign='center'>
        <Container>
          {/* <Grid divided inverted stackable>
            <Grid.Row>
              <Grid.Column width={8}>
                <Header inverted as="h4" content="About" />
                <List link inverted >
                <List.Item> Alibegović A. </List.Item>
                <List.Item> Cerić E. </List.Item>
                <List.Item> Hadžibulić A. </List.Item>
                <List.Item> Keško L. </List.Item>

                </List>
              </Grid.Column>

              <Grid.Column width={8}>
                <Header as="h4" inverted>
                  Contact
                </Header>
              </Grid.Column>
            </Grid.Row>
          </Grid> */}
          <Icon name='copyright' /> 2018 NWT Tim 17
        </Container>
      </Segment>
    );
  }
}
