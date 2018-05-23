import React, { Component } from "react";
import {
    Item,
    Icon,
    Button,
    Segment,
    List,
    Message
} from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import { Link } from "react-router-dom";

export default class ProjectionsList extends Component {
    getContent() {
        const { projections } = this.props;
        let projectionsList = [];
        let index = 0;

        for (let currentProjection of projections) {
            index += 1;

            const content = (
                <Segment color="yellow" key={index}>
                    <Item.Group divided>
                        <Item>
                            <Item.Image  style={{marginTop: 20}} size="small" src={logo} />

                            <Item.Content>
                                <Item.Header >{currentProjection.title}</Item.Header>
                                <Item.Description>
                                    <List>
                                        <List.Item> <b> Genre: </b> {currentProjection.genre} </List.Item>
                                        <List.Item> <b> Available tickets: </b> {currentProjection.actualTickets} </List.Item>
                                        <List.Item> <b> Max tickets: </b> {currentProjection.maxTickets} </List.Item>
                                    </List>
                                </Item.Description>
                                <Item.Extra>

                                    <Link to="/projections">
                                        <button class="positive ui button" primary floated="right" >
                                            Make a reservation
                                            <Icon name="right chevron" />
                                        </button>
                                    </Link>
                                    <Link to={'/projections/'+currentProjection.movieID}>
                                        <Button primary floated="right">
                                            View more
                                            <Icon name="right chevron" />
                                        </Button>
                                    </Link>


                                </Item.Extra>
                            </Item.Content>
                        </Item>
                    </Item.Group>
                </Segment>
            );

            projectionsList.push(content);
        }
        return projectionsList;
    }

    render() {
        const { projections, error } = this.props;

        if (!projections || projections.length === 0 || error) {
            return (
                <Message negative size="huge">
                    <Message.Header>
                        <Icon name="remove circle" />
                        We're sorry we can't find projections in database!
                    </Message.Header>
                </Message>
            );
        }
        return <div>
            {this.getContent()} </div>;
    }
}

