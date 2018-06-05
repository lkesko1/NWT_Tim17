import React, { Component } from "react";
import {
  Item,
  Icon,
  Segment,
  List,
  Message,
  Embed,
  Accordion,
  Divider,
  Comment,
  Label,
  Header,
  Form,
  Button,
  Massage
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import image from "../../images/DMOHA20140112005.jpg";
// import axios from "axios";
// import {reviewEndpoint} from "../../endpoints";

export default class Movie extends Component {
  getMovieContent() {
    const { movie, updateForm, addReview } = this.props;
    // const reviews = [];

    let reviews = [];
    if (movie.reviews) {
      for (let review of movie.reviews) {
        reviews.push(
          <Comment key="review.id">
            <Comment.Avatar
              src={require("../../images/user-avatar-grey.png")}
            />
            <Comment.Content>
              <Comment.Author as="a">Matt</Comment.Author>
              <Comment.Metadata>
                <div>review.comment </div>
                {/* TODO: dodati brisanje */}
              </Comment.Metadata>
              <Comment.Text>How artistic!</Comment.Text>
            </Comment.Content>
          </Comment>
        );
      }
    } else {
      reviews.push(
        <Message key="message-1" icon="write square" info content="Movie has no reviews" />
      );
    }

    let ReviewContent = (
      <Comment.Group>
        <Header as="h4" dividing>
          Movie Reviews
        </Header>
        {reviews}

        {localStorage.getItem("role") === "ROLE_USER" && (
          <Form reply>
            <Form.TextArea
              onChange={e => {
                updateForm(e, "review", e.target.value);
              }}
            />

            <Button
              positive
              content="Add review"
              labelPosition="left"
              icon="edit"
              primary
              onClick={addReview}
            />
          </Form>
        )}
      </Comment.Group>
    );

    const panels = [
      {
        title: {
          content: <Label color="blue" content="Movie reviews" />,
          key: "content-title"
        },
        content: {
          content: ReviewContent,
          key: "content-review"
        }
      }
    ];

    const content = (
      <Segment color="yellow">
        <Item.Group divided>
          <Item>
            <Item.Image style={{ marginTop: 20 }} size="small" src={logo} />

            <Item.Content>
              <Item.Header>{movie.Title}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item>
                    <b> Year: </b> {movie.Year}
                  </List.Item>
                  <List.Item>
                    <b> Genre: </b> {movie.Genre}
                  </List.Item>
                  <List.Item>
                    <b> Actors: </b>
                    {movie.Actors}
                  </List.Item>
                  <List.Item>
                    <b> Director: </b>
                    {movie.Director}
                  </List.Item>
                  <List.Item>
                    <b> Awards: </b>
                    {movie.Awards}
                  </List.Item>
                </List>
              </Item.Description>
            </Item.Content>
          </Item>
        </Item.Group>
        <Accordion size="large" panels={panels} />
        <Divider />

        <Embed id="do9zep1n8cU" placeholder={image} source="youtube" />
      </Segment>
    );

    return content;
  }

  render() {
    const { movie } = this.props;

    if (!movie) {
      return (
        <Message negative size="huge">
          <Message.Header>
            <Icon name="remove circle" />
            Sorry, we can't find movie!
          </Message.Header>
        </Message>
      );
    }
    return <div>{this.getMovieContent()}</div>;
  }
}
