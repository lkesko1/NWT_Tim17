import React, { Component } from "react";
import ProjectionsList from "./ProjectionsList";
import {Grid} from "semantic-ui-react";
import axios from "axios";
import {projectionsEndpoint} from "../../endpoints";

export default class ProjectionsScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            projections: [],

            error: null };
    }

    componentWillMount() {
        axios.get(projectionsEndpoint + "/movietimetable/get-projections")
            .then(response => {
                const projections = response.data;
                this.setState({projections: projections})
            })
            .catch(error => {
                this.setState({error: error})
            });

    }

    render() {
        const {projections, error} = this.state;

        return (
            <div>
                <Grid >
                    <Grid.Row>
                        <Grid.Column width={3} />
                        <Grid.Column width={10}>
                            <ProjectionsList projections={projections} error={error}/>
                        </Grid.Column>
                        <Grid.Column width={3} />
                    </Grid.Row>
                </Grid>
            </div>
        );
    }
}
