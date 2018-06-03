import React, { Component } from "react";
import { Button, Form, Grid, Header, Segment } from 'semantic-ui-react'
import axios from "axios";
import { authEndpoint } from "../../endpoints";
import { Redirect } from "react-router-dom";

const API_ROUTE = authEndpoint + '/register';

export default class SignUp extends Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            email: '',
            password: '',
            repeatPass: '',
            registered: false
        }

        this.updateState = this.updateState.bind(this);
    };

    updateState (event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }


    register (event) {

        let registerData = {
            username: this.state.username,
            password: this.state.pass,
            email: this.state.email
        }

        if (this.state.pass === this.state.repeatPass) {
            axios.post(API_ROUTE, registerData)
                .then(response => {
                    this.setState({
                        registered: true
                    });
                })
                .catch(function (error) {
                    console.log(error);
                    alert("Unsuccessful registration, please check your input!");
                });
        }
        else {
            alert("Password and Repeat Password don't match!");
        }
    }

    render() {

        if (this.state.registered) {
            return <Redirect to="/login"/>
        }

        return(
            <div className='login-form'>
                <style>{`
              body > div,
              body > div > div,
              body > div > div > div.login-form {
                height: 100%;
                }
    `       }</style>
                <Grid
                    textAlign='center'
                    style={{height: '100%'}}
                    verticalAlign='middle'
                >
                    <Grid.Column style={{maxWidth: 450}}>
                        <Header as='h2' color='yellow' textAlign='center'>
                            {' '}Sign up!
                        </Header>
                        <Form size='large'>
                            <Segment stacked>
                                <Form.Input
                                    fluid
                                    icon='user'
                                    iconPosition='left'
                                    placeholder='Username'
                                    name='username'
                                    value={this.state.username}
                                    onChange={this.updateState}
                                />
                                <Form.Input
                                    fluid
                                    icon='user'
                                    iconPosition='left'
                                    placeholder='Email'
                                    name='email'
                                    value={this.state.email}
                                    onChange={this.updateState}
                                />
                                <Form.Input
                                    fluid
                                    icon='lock'
                                    iconPosition='left'
                                    placeholder='Password'
                                    type='password'
                                    name='pass'
                                    value={this.state.pass}
                                    onChange={this.updateState}
                                />
                                <Form.Input
                                    fluid
                                    icon='lock'
                                    iconPosition='left'
                                    placeholder='Repeat password'
                                    type='password'
                                    name='repeatPass'
                                    value={this.state.repeatPass}
                                    onChange={this.updateState}
                                />

                                <Button color='green' fluid size='large'
                                        onClick={(event) => this.register(event)}>Sign Up</Button>
                            </Segment>
                        </Form>
                    </Grid.Column>
                </Grid>
            </div>);
    }
}

