package com.example.pandadesktop4.loginscreen.ro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public class PreferenceListResponse {

    @Expose
    @SerializedName("preferences")
    private List<PreferenceResponse> preferences;

    public List<PreferenceResponse> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<PreferenceResponse> preferences) {
        this.preferences = preferences;
    }
}
