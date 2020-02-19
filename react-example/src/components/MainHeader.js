import React from "react";

class MainHeader extends React.Component {

  render() {
    var backImgStyle = {
      backgroundImage: `url(${process.env.PUBLIC_URL +
        "/assets/img/sidebar-5.jpg"})`
    };

    return (
      <div className="sidebar" data-color="red" data-image="">
        <div className="sidebar-wrapper ps">
          <div className="logo">
            <a className="simple-text" href={process.env.PUBLIC_URL + "/"}>
              <img alt="logo"
                width="28"
                height="28"
                src={process.env.PUBLIC_URL + "/assets/img/angular-red.png"}
              />
              Oauth2 Example
            </a>
          </div>
          <ul className="nav responsive-nav">
            <li>
              <a href="/">
                <i className="pe-7s-graph"/> <span>Dashboard</span>
              </a>
            </li>
            <li>
              <a href="/users">
                <i className="pe-7s-user"/> <span>Users</span>
              </a>
            </li>
          </ul>
        </div>
        <div className="sidebar-background" style={backImgStyle}/>
      </div>
    );
  }
}

export default MainHeader;
