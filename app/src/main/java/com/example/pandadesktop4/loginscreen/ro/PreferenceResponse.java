package com.example.pandadesktop4.loginscreen.ro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public class PreferenceResponse {
    @Expose
    @SerializedName("date")
    private String date;

    @Expose
    @SerializedName("lunch")
    private boolean pref;

    public PreferenceResponse(String date, boolean lunch) {
        this.date = date;
        this.pref = lunch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getLunch() {
        return pref;
    }

    public void setLunch(boolean lunch) {
        this.pref = lunch;
    }


}
