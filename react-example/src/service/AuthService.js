import { BehaviorSubject } from "rxjs";
import queryString from "querystring";
import { handleResponse } from "../helper/HandleResponse";
import { authHeader } from "../helper/AuthHeader";
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
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
      Authorization: `Basic ${process.env.REACT_APP_API_CLIENT}`
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
      localStorage.setItem("token", JSON.stringify(token));
      const user = getUser();
      return user;
    })
    .catch(error => {
      console.error(error);
      return null;
    });
}

function getUser() {
  let header = authHeader();
  const requestOptions = {
    method: "GET",
    headers: header
  };

  return fetch(`${process.env.REACT_APP_API_URL}/users/me`, requestOptions)
    .then(handleResponse)
    .then(user => {
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
  localStorage.removeItem("token");
  localStorage.removeItem("currentUser");
  currentUserSubject.next(null);
}
