package com.example.pandadesktop4.loginscreen.repo;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by pandadesktop4 on 21/7/17.
 */

public class RestClient {

    public static String authToken;

    public static RestAdapter getRestAdapter() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://192.168.1.182:9000")
                .build();
        return adapter;
    }

    public static RestAdapter getAuthenticationRestAdapter() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Authorization", authToken);
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://192.168.1.182:9000")
                .setRequestInterceptor(requestInterceptor)
                .build();
        return restAdapter;

    }

}