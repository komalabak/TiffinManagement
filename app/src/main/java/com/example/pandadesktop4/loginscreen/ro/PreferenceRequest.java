package com.example.pandadesktop4.loginscreen.ro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public class PreferenceRequest {
    @Expose
    @SerializedName("date")
    private String date;

    @Expose
    @SerializedName("lunch")
    private boolean lunch;

    public PreferenceRequest(String date, boolean lunch) {
        this.date = date;
        this.lunch = lunch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getLunch() {
        return lunch;
    }

    public void setLunch(boolean lunch) {
        this.lunch = lunch;
    }


}
