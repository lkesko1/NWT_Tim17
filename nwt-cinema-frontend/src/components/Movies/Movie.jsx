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
  Massage,
  Dimmer, 
  Loader
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import image from "../../images/DMOHA20140112005.jpg";
import _ from "lodash";
// import axios from "axios";
// import {reviewEndpoint} from "../../endpoints";

export default class Movie extends Component {


  getMovieContent() {
    const { movie, updateForm, addReview } = this.props;
    // const reviews = [];

    let reviews = [];
    if (movie.movieReviews && movie.movieReviews.length > 0) {
      for (let review of movie.movieReviews) {
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
              <Comment.Text>review.comment </Comment.Text>
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
              onClick={this.props.addReview}
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

    const youtubeId = _.split(movie.youtubeUrl,'?v=')[1];

    
    const content = (
      <Segment color="yellow">
        <Item.Group divided>
          <Item>
            <Item.Image style={{ marginTop: 20 }} size="small" src={logo} />

            <Item.Content>
              <Item.Header>{movie.title}</Item.Header>
              <Item.Description>
                <List>
                  <List.Item>
                    <b> Year: </b> {movie.year}
                  </List.Item>
                  <List.Item>
                    <b> Genre: </b> {movie.genre}
                  </List.Item>
                  <List.Item>
                    <b> Actors: </b>
                    {movie.actors}
                  </List.Item>
                  <List.Item>
                    <b> Director: </b>
                    {movie.director}
                  </List.Item>
                  <List.Item>
                    <b> Awards: </b>
                    {movie.awards}
                  </List.Item>
                </List>
              </Item.Description>
            </Item.Content>
          </Item>
        </Item.Group>
        <Accordion size="large" panels={panels} />
        <Divider />

        <Embed id={youtubeId} placeholder={image} source="youtube" />
      </Segment>
    );

    return content;
  }

  render() {
    const { movie, error } = this.props;

    if (!movie && !error) {
      return (
        <Dimmer active inverted>
          <Loader content="Loading" />
        </Dimmer>
      );
    }

    if (!movie || error) {
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
