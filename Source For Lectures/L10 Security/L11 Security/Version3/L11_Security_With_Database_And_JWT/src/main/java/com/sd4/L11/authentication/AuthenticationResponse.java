package com.sd4.L11.authentication;

/*
This class is used to send the generated JWT back to the client after
successful authentication.
 */
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }


    public String toString() {
        return "AuthenticationResponse(jwt=" + this.getJwt() + ")";
    }
}