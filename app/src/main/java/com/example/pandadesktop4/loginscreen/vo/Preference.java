package com.example.pandadesktop4.loginscreen.vo;

import com.example.pandadesktop4.loginscreen.ro.PreferenceResponse;

import java.util.Date;

/**
 * Created by pandadesktop4 on 24/7/17.
 */
public class Preference {
    public Date date;
    public boolean lunch;

    public Preference(Date date, boolean lunch) {
        this.date = date;
        this.lunch = lunch;
    }

    public Preference(PreferenceResponse preferenceResponse) {
        this.date = new Date(preferenceResponse.getDate());
        this.lunch = preferenceResponse.getLunch();
    }

    @Override
    public String toString() {
        return "Preference{" +
                "date=" + date +
                ", lunch=" + lunch +
                '}';
    }
}
