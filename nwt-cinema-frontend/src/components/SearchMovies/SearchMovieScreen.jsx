import React, { Component } from "react";
import MovieSearchMovie from "./MovieSearchMovie";
import {Grid} from "semantic-ui-react";
import axios from "axios";
import {movieEndpoint} from "../../endpoints";

export default class SearchMovieScreen extends Component {
    constructor(props) {
        super(props);
        this.state = { movie: null, error: null };
    }

    componentWillMount() {
        axios.get(
            // "http://www.omdbapi.com/?i=" + this.props.match.params.id + "&apikey=2d5ee0b5")
            movieEndpoint + "/omdb/" + this.props.match.params.id 
          )
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

        return (
            <div>
                <Grid >
                    <Grid.Row>
                        <Grid.Column width={3} />
                        <Grid.Column width={10}>
                            <MovieSearchMovie movie={movie} error={error}/>
                        </Grid.Column>
                        <Grid.Column width={3} />
                    </Grid.Row>
                </Grid>
            </div>
        );
    }
}
