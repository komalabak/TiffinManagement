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
    @SerializedName("pref")
    private boolean pref;

    public PreferenceRequest(String date, boolean pref) {
        this.date = date;
        this.pref = pref;
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

    public void setLunch(boolean pref) {
        this.pref = pref;
    }


}
