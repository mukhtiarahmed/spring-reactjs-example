export function authHeader() {
  // return authorization header with access token
  const token = localStorage.getItem("token");
  if (token) {
     let data = JSON.parse(token);
    return { Authorization: `Bearer ${data.access_token}` };
  } else {
    return {};
  }
}
