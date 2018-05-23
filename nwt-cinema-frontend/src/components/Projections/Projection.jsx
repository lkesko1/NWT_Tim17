import React, { Component } from "react";
import {
    Item,
    Icon,
    Segment,
    List,
    Message,
    Embed,
    Divider
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import image from "../../images/DMOHA20140112005.jpg"

export default class Projection extends Component {
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
                                </List>
                            </Item.Description>
                        </Item.Content>
                    </Item>
                </Item.Group>
                <Divider/>

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

