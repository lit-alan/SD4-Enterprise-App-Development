package com.sd4.L11.authentication;


/*
This class is used to send the generated JWT back to the client after
successful authentication.
 */
public class AuthenticationResponse {
    private final String accessToken;
    private final String refreshToken; //i added this field to allow me to send the refresh token back in the response


    public AuthenticationResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}