package com.example.pandadesktop4.loginscreen.ro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pandadesktop4 on 21/7/17.
 */
//{
//        "username": "abcd",
//        "password":"abcd"
//
//        }
public class LoginRequest {
    @Expose
    @SerializedName("username")
    private String userName;

    @Expose
    @SerializedName("password")
    private String password;

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
