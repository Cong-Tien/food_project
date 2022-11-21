package com.lecongtien.food_project.payload.request;

public class SignInRequest {
    private String username;
    private String password;
    private boolean isSuccess;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
