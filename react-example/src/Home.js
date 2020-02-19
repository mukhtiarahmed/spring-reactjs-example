import React from "react";
import MainHeader from "./components/MainHeader";
import MainContent from "./components/MainContent";
import { history } from "./helper/History";
import { authenticationService } from "./service/AuthService";

class Home extends React.Component {
  componentDidMount() {
    authenticationService.currentUser.subscribe(x =>
      this.setState({ currentUser: x })
    );
  }

  logout() {
    authenticationService.logout();
    history.push("/login");
  }

  render() {
    return (
      <div className="wrapper">
        <MainHeader />
        <div className="main-panel ps ps--active-y">
          <nav className="navbar navbar-default navbar-expand-lg">
            <div className="container">
              <div className="navbar-translate">
                <div className="navbar-brand">
                  Admin Console<div className="ripple-container"></div>
                </div>
                <ul className="nav navbar-nav navbar-righ ">
                  <li>
                    <a href="#/" onClick={this.logout}>
                      Log out
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <MainContent />
        </div>
      </div>
    );
  }
}

export default Home;
