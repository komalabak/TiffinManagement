package com.example.pandadesktop4.loginscreen.repo;

import com.example.pandadesktop4.loginscreen.ro.LoginRequest;
import com.example.pandadesktop4.loginscreen.ro.LoginResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by pandadesktop4 on 21/7/17.
 */

public interface LoginAPI {
    @POST("/login")
    public void login(@Body LoginRequest loginRequest, Callback<ServerResponse> response);
}
