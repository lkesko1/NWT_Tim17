import React, { Component } from "react";
import {Grid} from "semantic-ui-react";
import axios from "axios";
import {projectionsEndpoint} from "../../endpoints";
import Projection from "./Projection";

export default class ProjectionScreen extends Component {
    constructor(props) {
        super(props);
        this.state = { movie: null, error: null };
    }

    componentWillMount() {
        axios.get(projectionsEndpoint + "/movietimetable/get-details/"  +this.props.match.params.id)
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
                            <Projection movie={movie} error={error}/>
                        </Grid.Column>
                        <Grid.Column width={3} />
                    </Grid.Row>
                </Grid>
            </div>
        );
    }
}
