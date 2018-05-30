import React, { Component } from "react";
import {Icon, Message} from "semantic-ui-react";
import axios from "axios";
import {movieEndpoint} from "../../endpoints";

export default class AddMovieToDatabase extends Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            endStatus: '' };
    }

    componentWillMount() {
        axios.post(
            movieEndpoint + "/addMovie/" + this.props.match.params.id )
            .then(response => {
                this.setState
                    ({
                    endStatus : response.request.status
                    })
                })
            .catch(error => {
                 this.setState({error: error})
            });
    }

    render() {


        if(this.state.endStatus === 200)
        {
            return (
                <div class="ui success message">
                    <i class="close icon"></i>
                    <div class="header">
                        Movie added!
                    </div>
                    <p>Now you can create projection for this movie.</p>
                </div>
            );
        }
        else
            return (
                <Message negative size="huge">
                    <Message.Header>
                        <Icon name="remove circle" />
                        We're sorry, error occurred
                    </Message.Header>
                </Message>
            );
        }



}
