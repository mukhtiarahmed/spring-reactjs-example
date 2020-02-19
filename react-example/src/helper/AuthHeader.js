export function authHeader() {
  // return authorization header with access token
  const token = localStorage.getItem("token");
  console.log(token.access_token);
  debugger;
  if (token && token.access_token) {
    return { Authorization: `Bearer ${token.access_token}` };
  } else {
    return {};
  }
}
