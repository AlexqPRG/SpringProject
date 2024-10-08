package com.API.shopAPI.DTO;


public class JwtAuthenticationResponse {
    private String token;

    public JwtAuthenticationResponse(){}
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
