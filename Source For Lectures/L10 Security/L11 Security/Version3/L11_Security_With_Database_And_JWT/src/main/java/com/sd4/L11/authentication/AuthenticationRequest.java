package com.sd4.L11.authentication;

/*  When a user tries to authenticate, they submit their username and password
    in a request body, which are then mapped to an object of this class.
 */
public class AuthenticationRequest {
    private String username;
    private String password;

    public AuthenticationRequest() {
    }


    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String toString() {
        return "AuthenticationRequest(username=" + this.getUsername() + ", password=" + this.getPassword() + ")";
    }
}
