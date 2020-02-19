import React from "react";

class MainNav extends React.Component {
  render() {
    return (
      <nav className="navbar navbar-default navbar-expand-lg">
        <div className="container">
          <div className="navbar-translate">
            <div className="navbar-brand">
              Admin Console<div className="ripple-container"></div>
            </div>
            <ul className="nav navbar-nav navbar-righ ">
              <li>
                <a href="#/" onClick={this.props.logout}>
                  Log out
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

export default MainNav;
