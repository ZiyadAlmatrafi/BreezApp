package com.example.breezapp.models;


public class LoginResponse {


    private String password;
    private String username;
    private String error;
    private User user;

    public LoginResponse(String password, String username, String error, User user) {
        this.password = password;
        this.username = username;
        this.error = error;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getError() {
        return error;
    }

    public User getUser() {
        return user;
    }
}
