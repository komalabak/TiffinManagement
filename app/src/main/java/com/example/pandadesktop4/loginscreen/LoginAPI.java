package com.example.pandadesktop4.loginscreen;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by pandadesktop4 on 21/7/17.
 */

public interface LoginAPI {
    @POST("/login")
    public void login(@Body LoginRequest loginRequest, Callback<ServerResponse> response);
}
