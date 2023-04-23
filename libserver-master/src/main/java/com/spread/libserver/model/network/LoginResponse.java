package com.spread.libserver.model.network;

import com.spread.libserver.model.constant.Message;

public class LoginResponse extends Response{
    private  String Token;
    private int userType;
    public LoginResponse(boolean status, String op, Message msg) {
        super(status, op, msg);
    }

    public LoginResponse(boolean status, String op) {
        super(status, op);
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
