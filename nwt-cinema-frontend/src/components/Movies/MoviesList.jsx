import React, { Component } from "react";
import {
  Item,
  Icon,
  Button,
  Grid,
  Segment,
  Container
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";

export default class MoviesList extends Component {
  render() {
    const { movies } = this.props;

    return (
      <div>
        <Grid celled="internally">
          <Grid.Row>
            <Grid.Column width={3}>
              {/* <Image src='/assets/images/wireframe/image.png' /> */}
            </Grid.Column>
            <Grid.Column width={10}>
              <Item.Group divided>
                <Item>
                  <Item.Image size="small" src={logo} />

                  <Item.Content>
                    <Item.Header as="a">Movie Title</Item.Header>
                    <Item.Description>description</Item.Description>
                    <Item.Extra>
                      <Icon color="green" name="check" /> 121 Reviews
                      <Button primary floated="right">
                        View more
                        <Icon name="right chevron" />
                      </Button>
                    </Item.Extra>
                  </Item.Content>
                </Item>
              </Item.Group>
            </Grid.Column>
            <Grid.Column width={3}>
              {/* <Image src='/assets/images/wireframe/image.png' /> */}
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </div>
    );
  }
}
