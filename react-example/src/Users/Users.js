import React from "react";

import { authenticationService } from "../service/AuthService";
import MainHeader from "../components/MainHeader";
import MainNav from "../components/MainNav";
import {history} from "../helper/History";
import {authHeader} from "../helper/AuthHeader";
import {handleResponse} from "../helper/HandleResponse";

class Users extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users : []
        }

    }

    componentDidMount() {
        this.getUsers();
    }

    getUsers() {
        let header = authHeader();
        const requestOptions = {
            method: "GET",
            headers: header
        };


         fetch(`${process.env.REACT_APP_API_URL}/users`, requestOptions)
            .then(handleResponse)
            .then(response => {
                if(response) {
                    this.setState({users: response.data});
                }

            })
            .catch(error => {
                console.error(error);
            });
    }


    logout() {
        authenticationService.logout();
        history.push("/login");
    }



    viewUser(userId) {

    }

    render() {
        return (
            <div className="wrapper">
                <MainHeader />
                <div className="main-panel ps ps--active-y">
                   <MainNav />
                    <div className="main-content">
                        <div className="container-fluid">
                            <div className="row">
                                <div className="col-md-12">
                                    <div className="card">
                                        <div className="header">
                                            <h4 className="title">Users </h4>
                                        </div>
                                        <div className="content table-responsive table-full-width" id="season-table">

                                            <table className="table table-hover table-striped table-sm">
                                                <thead>
                                                <tr>
                                                    <th>User Name</th>
                                                    <th>Email Address</th>
                                                    <th>Full Name</th>
                                                    <th>Phone Number</th>
                                                    <th>View Detail</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                {this.state.users.map((user) => (
                                                    <tr>
                                                        <td>{user.userName}</td>
                                                        <td>{user.emailAddress}</td>
                                                        <td>{user.fullName}</td>
                                                        <td>{user.phoneNumber}</td>
                                                        <td><a href="/#" onClick={this.viewUser(user.id)}
                                                               title="View User" className="btn btn-fill btn-danger">
                                                            <i className="pe-7s-close-circle"></i></a></td>

                                                    </tr>

                                                ))}

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Users;