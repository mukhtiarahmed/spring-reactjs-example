import React from "react";

class AuthHeader extends React.Component {


  render() {
    const headerStyle = {
      backGround: "#FF4A55"
    };

    return (
      <nav style={headerStyle} className="navbar navbar-default App-header">
        <div>
          <a className="navbar-brand" href={process.env.PUBLIC_URL + "/"}>
            <img alt="logo"
              width="30"
              height="30"
              src={process.env.PUBLIC_URL + "/assets/img/angular-red.png"}
            />
          </a>
        </div>

        <div className="container-fluid">
          <div className="navbar-header"></div>
        </div>
      </nav>
    );
  }
}

export default AuthHeader;
