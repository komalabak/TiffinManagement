package com.example.pandadesktop4.loginscreen.repo;

import com.example.pandadesktop4.loginscreen.ro.EmptyResponse;
import com.example.pandadesktop4.loginscreen.ro.PreferenceListResponse;
import com.example.pandadesktop4.loginscreen.ro.PreferenceRequest;
import com.google.android.gms.common.api.Result;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public interface PreferenceAPI {

    @GET("/preferences")
    public void getAllPreferences(@Query("month") Integer month, @Query("year") Integer year, Callback<PreferenceListResponse> response);


    @POST("/preference")
    public void saveTiffinPreference(@Body PreferenceRequest preferenceRequest, Callback<Response> response);

}
