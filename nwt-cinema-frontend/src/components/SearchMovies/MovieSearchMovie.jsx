import React, { Component } from "react";
import {
    Item,
    Icon,
    Segment,
    List,
    Message,
    Embed,
    Divider,
    Button,
    Dimmer,
    Loader
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import image from "../../images/DMOHA20140112005.jpg"
import { Link } from "react-router-dom";


export default class MovieSearchMovie extends Component {
    getMovieContent() {
        const { movie } = this.props;

        const content = (
            <Segment color="yellow" >
                <Item.Group divided>
                    <Item>
                        <Item.Image style={{marginTop: 20}} size="small" src={logo} />

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
                                    <Link to={'/add-movie/'+movie.imdbID}>
                                        <Button primary floated="right">
                                            Add to database
                                            <Icon name="right chevron" />
                                        </Button>
                                    </Link>
                                </List>
                            </Item.Description>
                        </Item.Content>
                    </Item>
                </Item.Group>
                <Divider/>




                <Embed
                    id="do9zep1n8cU"
                    placeholder={image}
                    source="youtube"
                />
            </Segment>
        );

        return content;
    }

    render() {
        const { movie, error } = this.props;

        if (!movie && !error){
            return (
                <Dimmer active inverted>
                  <Loader content="Loading" />
                </Dimmer>
              );
        }

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

