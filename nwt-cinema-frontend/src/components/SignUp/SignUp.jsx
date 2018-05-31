import React, { Component } from "react";
import { Button, Form, Grid, Header, Image, Message, Segment } from 'semantic-ui-react'
import { Redirect } from 'react-router';


export default class SignUp extends Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            email: '',
            pass: '',
            repeatPass: '',
            registered: false
        }

        //this.updateState = this.updateState.bind(this);
    };


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
                                />
                                <Form.Input
                                    fluid
                                    icon='user'
                                    iconPosition='left'
                                    placeholder='Email'
                                />
                                <Form.Input
                                    fluid
                                    icon='lock'
                                    iconPosition='left'
                                    placeholder='Password'
                                    type='password'
                                />
                                <Form.Input
                                    fluid
                                    icon='lock'
                                    iconPosition='left'
                                    placeholder='Repeat password'
                                    type='password'
                                />

                                <Button color='green' fluid size='large'>Sign Up</Button>
                            </Segment>
                        </Form>
                    </Grid.Column>
                </Grid>
            </div>);
    }
}

