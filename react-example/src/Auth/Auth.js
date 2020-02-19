import React from "react";
import AuthHeader from "../components/AuthHeader";
import AuthConent from "../components/AuthContent";
import { authenticationService } from "../service/AuthService";
import { Redirect } from "react-router";

class Auth extends React.Component {
  render() {
    const currentUser = authenticationService.currentUserValue;
    if (currentUser) {
      return <Redirect to={{ pathname: "/" }} />;
    }
    return (
      <div>
        <AuthHeader />
        <AuthConent />
      </div>
    );
  }
}

export default Auth;
