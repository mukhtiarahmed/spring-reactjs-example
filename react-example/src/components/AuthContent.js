import React from "react";
import { authenticationService } from "../service/AuthService";

const validateForm = errors => {
  let valid = true;
  Object.values(errors).forEach(
    // if we have an error string set valid to false
    val => val.length > 0 && (valid = false)
  );
  return valid;
};

class AuthContent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      errors: {
        username: "",
        password: "",
        authFail: ""
      }
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    event.preventDefault();
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case "username":
        errors.username =
          value.length < 3 ? "User Name must be 3 characters long!" : "";
        break;
      case "password":
        errors.password =
          value.length < 6 ? "Password must be 6 characters long!" : "";
        break;
      default:
        break;
    }
    this.setState({ errors, [name]: value }, () => {
      console.log(errors);
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    if (validateForm(this.state.errors)) {
      console.info("Valid Form");
    } else {
      console.error("Invalid Form");
    }

    authenticationService.login(this.state.username, this.state.password);
  }

  render() {
    const { errors } = this.state;
    return (
      <div className="content">
        <div className="container">
          <div className="row">
            <div className="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
              <form onSubmit={this.handleSubmit}>
                <div className="card">
                  <div className="header text-center">Login</div>
                  <div className="content">
                    <div className="form-group">
                      <label htmlFor="name">Email</label>
                      <input
                        type="text"
                        id="username"
                        name="username"
                        className="form-control"
                        placeholder="User Name"
                        value={this.state.email}
                        onChange={this.handleChange}
                      />
                      {errors.username.length > 0 && (
                        <span className="text-danger">{errors.username}</span>
                      )}
                    </div>
                    <div className="form-group">
                      <label htmlFor="password">Password</label>
                      <input
                        type="password"
                        name="password"
                        className="form-control"
                        id="password"
                        placeholder="Password"
                        onChange={this.handleChange}
                      />
                      {errors.password.length > 0 && (
                        <span className="text-danger">{errors.password}</span>
                      )}
                    </div>
                    <div className="form-group">
                      {errors.authFail.length > 0 && (
                        <span className="text-danger">{errors.authFail}</span>
                      )}
                    </div>
                  </div>
                  <div className="footer text-center">
                    <button
                      className="btn btn-fill btn-danger btn-wd"
                      type="submit"
                    >
                      Login
                    </button>
                  </div>
                  <div className="header text-center"></div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default AuthContent;
