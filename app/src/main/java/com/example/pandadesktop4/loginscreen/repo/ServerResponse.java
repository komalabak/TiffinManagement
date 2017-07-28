package com.example.pandadesktop4.loginscreen.repo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pandadesktop4 on 28/7/17.
 */
public class ServerResponse {
    @Expose
    @SerializedName("authToken")
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

}
