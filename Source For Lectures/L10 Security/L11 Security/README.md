**Version 1:** Usernames, Passwords and Roles Defined in the Code.

**Version 2:** Usernames, Passwords and Roles Defined in the Database (code updated to include a listener that logs every successful login and logout)

**Version 3:** Source With Usernames, Passwords and Roles Defined in the DB. Plus it uses a JWT (Java Web Token) for AutnN/AuthX. All RestControllers will need to use JWT.

**Version 4:** The project demonstrates a Spring Boot authentication and authorisation system using Spring Security and JSON Web Tokens (JWT). Users authenticate using their email address and password, after which the application issues a short-lived access token (3 minutes) and a longer-lived refresh token (7 days). The access token is included in the HTTP Authorization header when accessing protected endpoints, while the refresh token can be used to obtain a new access token without requiring the user to log in again. Refresh tokens are stored in a database to support validation and revocation, while access tokens are managed without database storage. When a user logs out, their refresh token is deleted from the database and their access token is added to an in-memory blacklist, preventing further use even before it expires. The project demonstrates JWT generation and validation, protected endpoints, token renewal, logout handling and token revocation using Spring Boot and Spring Security. Examine the **README** in the project for a complete breakdown of what the code does. There is a new DB script for this version and you will find it within the `resources` folder of the project.

