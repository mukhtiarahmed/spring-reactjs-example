import { BehaviorSubject } from "rxjs";
import queryString from "querystring";
import { handleResponse } from "../helper/HandleResponse";
require("dotenv").config();
const currentUserSubject = new BehaviorSubject(
  JSON.parse(localStorage.getItem("currentUser"))
);

export const authenticationService = {
  login,
  logout,
  currentUser: currentUserSubject.asObservable(),
  get currentUserValue() {
    return currentUserSubject.value;
  }
};

function login(username, password) {
  console.log(`${process.env.REACT_APP_API_URL}`);
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
      Authorization:
        "Basic Y2ZmZTM5OTAtNmYwZS0xMWU4LWI3NTAtNGQ4NjE0Yzk0MGZmOnNlY3JldA=="
    },
    body: queryString.stringify({
      grant_type: "password",
      scope: "trust",
      username: username,
      password: password
    })
  };

  return fetch(`${process.env.REACT_APP_API_URL}/oauth/token`, requestOptions)
    .then(handleResponse)
    .then(token => {
      // store user details and jwt token in local storage to keep user logged in between page refreshes
      console.log(token);
      localStorage.setItem("token", JSON.stringify(token));
      const user = getUser(token.access_token);
      return user;
    })
    .catch(error => {
      console.error(error);
      return null;
    });
}

function getUser(token) {
  console.log(token);
  const requestOptions = {
    method: "GET",
    headers: { Authorization: `Bearer ${token}` }
  };
  console.log(`${process.env.REACT_APP_API_URL}`);

  return fetch(`${process.env.REACT_APP_API_URL}/users/me`, requestOptions)
    .then(handleResponse)
    .then(user => {
      console.log(user.data);
      localStorage.setItem("currentUser", JSON.stringify(user.data));
      currentUserSubject.next(user);

      return user;
    })
    .catch(error => {
      console.error(error);
      return null;
    });
}

function logout() {
  // remove user from local storage to log user out
  localStorage.removeItem("currentUser");
  currentUserSubject.next(null);
}
