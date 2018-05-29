import React, { Component } from "react";
import { Item, Icon, Button, Segment, List, Message } from "semantic-ui-react";
import logo from "../../images/cinema (1).png";
import { Link } from "react-router-dom";
import { NewReservationModal } from "../Reservations/NewReservationModal";

export default class ProjectionsList extends Component {
    componentDidMount() {
    this.setState({ reservationModalVisible: false, tickets: 1});
  }

  showReservationModal(id) {
    this.setState({ reservationModalVisible: true, selectedProjectionId: id, error:null});
  }

  hideReservationModal(){
    this.setState({ reservationModalVisible: false, selectedProjectionId:null, error:null});
  }

  updateForm(e, key, value){
    if (key == 'projection') {
      this.setState({...this.state, selectedProjectionId: value})
    } else {
      this.setState({...this.state, tickets: value})
    }
  }

  getContent() {
    const { projections } = this.props;
    let projectionsList = [];

    for (let currentProjection of projections) {
      const content = (
        <Segment key={currentProjection.projectionID} color="yellow">
         

          <Item.Group divided>
            <Item>
              <Item.Image style={{ marginTop: 20 }} size="small" src={logo} />

              <Item.Content>
                <Item.Header>{currentProjection.title}</Item.Header>
                <Item.Description>
                  <List>
                    <List.Item>
                      {" "}
                      <b> Genre: </b> {currentProjection.genre}{" "}
                    </List.Item>
                    <List.Item>
                      {" "}
                      <b> Available tickets: </b>{" "}
                      {currentProjection.actualTickets}{" "}
                    </List.Item>
                    <List.Item>
                      {" "}
                      <b> Max tickets: </b> {currentProjection.maxTickets}{" "}
                    </List.Item>
                  </List>
                </Item.Description>
                <Item.Extra>
                  <Link to="/projections">
                    <Button
                    key={currentProjection.projectionID}
                      className="positive ui button"
                      primary
                      floated="right"
                      onClick={this.showReservationModal.bind(this, currentProjection.projectionID)}
                    >
                      Make a reservation
                      <Icon name="right chevron" />
                    </Button>
                  </Link>
                  <Link to={"/projections/" + currentProjection.movieID}>
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
     <NewReservationModal
            reservationModalVisible={this.state.reservationModalVisible}
            hideReservationModal={this.hideReservationModal.bind(this)}
            projections={projections}
            selectedProjectionId={this.state.selectedProjectionId}
            updateForm={this.updateForm.bind(this)}
            tickets={this.state.tickets}
          />
          {this.getContent()} </div>;
  }
}
