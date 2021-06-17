import React, { Component } from 'react';

import { Card, Form, Button, Col, Table, Image, ButtonGroup } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSave, faPlusSquare, faUndo, faList, faEdit, faTrash, faFilter } from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default class Standing extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.teams = []
        this.bookChange = this.stateChange.bind(this);
        this.submitBook = this.findByCountryAndLeagueAndTeam.bind(this);
    }

    initialState = {
        country: '', league: '', team: ''
    };

    componentDidMount() {
        
    }

    findByCountryAndLeagueAndTeam = (event) => {
        event.preventDefault();
        let axiosConfig = {
            headers: {
                'Content-Type': 'application/json;charset=UTF-8',
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Request-Method": "GET"
            }
          };
        axios.get("http://localhost:8080/standing",{ params: { countryName: this.state.country,leagueName:this.state.league,teamName:this.state.team }},axiosConfig)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        teams: response.data.teamStandingList
                     });
                }
            }).catch((error) => {
                console.error("Error - " + error);
            });
    };

    stateChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    render() {
        const { country, league, team, teams} = this.state;
        console.log(teams)

        return (
            <div>
                <div>
                    <Card className={"border border-dark bg-dark text-white"}>
                        <Card.Header>
                            Filter Teams
                    </Card.Header>
                        <Form onReset={this.resetBook} onSubmit={this.findByCountryAndLeagueAndTeam} id="bookFormId">
                            <Card.Body>
                                <Form.Row>
                                    <Form.Group as={Col} controlId="formGridTitle">
                                        <Form.Label>Country Name</Form.Label>
                                        <Form.Control required autoComplete="off"
                                            type="text" name="country"
                                            value={country} onChange={this.stateChange}
                                            className={"bg-dark text-white"}
                                            placeholder="Enter Country Name" />
                                    </Form.Group>
                                    <Form.Group as={Col} controlId="formGridAuthor">
                                        <Form.Label>League Name</Form.Label>
                                        <Form.Control required autoComplete="off"
                                            type="text" name="league"
                                            value={league} onChange={this.stateChange}
                                            className={"bg-dark text-white"}
                                            placeholder="Enter League Name" />
                                    </Form.Group>
                                    <Form.Group as={Col} controlId="formGridCoverPhotoURL">
                                        <Form.Label>Team Name</Form.Label>
                                        <Form.Control required autoComplete="off"
                                            type="text" name="team"
                                            value={team} onChange={this.stateChange}
                                            className={"bg-dark text-white"}
                                            placeholder="Enter Team Name" />
                                    </Form.Group>
                                </Form.Row>

                            </Card.Body>
                            <Card.Footer style={{ "textAlign": "right" }}>
                                <Button size="sm" variant="success" type="submit">
                                    <FontAwesomeIcon icon={faFilter} /> Filter
                                </Button>{' '}
                                <Button size="sm" variant="info" type="reset">
                                    <FontAwesomeIcon icon={faUndo} /> Reset
                                </Button>
                            </Card.Footer>
                        </Form>
                    </Card>
                </div>

                <div>
                    <Card className={"border border-dark bg-dark text-white"}>
                        <Card.Header><FontAwesomeIcon icon={faList} /> Teams Standing</Card.Header>
                        <Card.Body>
                            <Table bordered hover striped variant="dark">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Standing</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.teams.length === 0 ?
                                            <tr align="center">
                                                <td colSpan="6">No Teams Available.</td>
                                            </tr> :
                                            this.state.teams.map((team) => (
                                                <tr key={team.teamId}>
                                                    
                                                    <td>{team.teamId}</td>
                                                    <td>{team.teamName}</td>
                                                    <td>{team.standing}</td>
                                                </tr>
                                            ))
                                    }
                                </tbody>
                            </Table>
                        </Card.Body>
                    </Card>
                </div>

            </div>
        );
    }
}