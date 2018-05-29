import React, { Component } from "react";
import MovieSearchMovie from "./MovieSearchMovie";
import {Grid, Button, Icon} from "semantic-ui-react";
import axios from "axios";
import {movieEndpoint} from "../../endpoints";

export default class AddMovieToDatabase extends Component {
    constructor(props) {
        super(props);
        this.state = { movie: null, error: null };
    }

    componentWillMount() {
        axios.post(
            movieEndpoint + "/addMovie/ " + this.props.match.params.id )
            .then(response => {
                const movie = response.data;
                this.setState({movie: movie})
            })
            .catch(error => {
                this.setState({error: error})
            });
    }

    render() {

        const {movie, error} = this.state;

        if (!movies || movies.length === 0 || error) {
            return (
                <Message negative size="huge">
                    <Message.Header>
                        <Icon name="remove circle" />
                        We're sorry we can't find movies in database!
                    </Message.Header>
                </Message>
            );
        }
        return <div>
            
                <button onClick={() => this.setState({ show: true })}>Alert</button>
                <SweetAlert
                    show={this.state.show}
                    title="Demo"
                    text="SweetAlert in React"
                    onConfirm={() => this.setState({ show: false })}
                />
             </div>;}


}
