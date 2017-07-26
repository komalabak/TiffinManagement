package com.example.pandadesktop4.loginscreen;

import retrofit.RestAdapter;

/**
 * Created by pandadesktop4 on 21/7/17.
 */

public enum RestClient {;
    public static RestAdapter getRestAdapter(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://192.168.1.185:3000")
                .build();
        return adapter;
    }
}
