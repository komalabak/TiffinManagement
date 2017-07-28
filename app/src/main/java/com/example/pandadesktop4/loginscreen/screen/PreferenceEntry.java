package com.example.pandadesktop4.loginscreen.screen;

//import android.icu.util.Calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pandadesktop4.loginscreen.R;
import com.example.pandadesktop4.loginscreen.Util;
import com.example.pandadesktop4.loginscreen.repo.PreferenceAPI;
import com.example.pandadesktop4.loginscreen.repo.RestClient;
import com.example.pandadesktop4.loginscreen.ro.PreferenceListResponse;
import com.example.pandadesktop4.loginscreen.ro.PreferenceResponse;
import com.example.pandadesktop4.loginscreen.vo.Preference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PreferenceEntry extends AppCompatActivity {

    private Integer current_month;
    private List<Preference> currentMonthPreferences;
    private Integer current_year;
    ListView currentMonthPreferencesView;
    Button goToNextMonth, gotToPreviousMonth;
    TextView currentMonthLabel;
    private CustomAdapter adapter;


    private void initializePreferences(Integer month, Integer year) {
        this.current_month = month;
        this.current_year = year;
//        this.currentMonthPreferences = new ArrayList<>();

        List<Date> dates = Util.getDatesForMonth(month, year);
        for (Date date : dates) {
            currentMonthPreferences.add(new Preference(date, false));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_entry);
        currentMonthPreferencesView = (ListView) findViewById(R.id.listView);
        goToNextMonth = (Button) findViewById(R.id.nextbutton);
        gotToPreviousMonth = (Button) findViewById(R.id.previousbutton);
        currentMonthLabel = (TextView) findViewById(R.id.monthtext);



        Date today = new Date();
        reload(today.getMonth(), today.getYear());

    }

    private void reload(Integer month, Integer year) {
        initializePreferences(month, year); // TODO get month and year from intent

        currentMonthLabel.setText(new SimpleDateFormat("MMMMMMM").format(Util.getDate(month, year)));
        PreferenceAPI api = RestClient.getAuthenticationRestAdapter().create(PreferenceAPI.class);
        call();

        api.getAllPreferences(new Callback<PreferenceListResponse>() {
            @Override
            public void success(PreferenceListResponse preferenceListResponse, Response response) {

                for (PreferenceResponse preferenceResponse : preferenceListResponse.getPreferences()) {
                    for (Preference preference : currentMonthPreferences) {
                        if (preferenceResponse.getDate().equals(preference.date)) {
                            preference.lunch = preferenceResponse.getLunch();
                        }
                    }
                }
                call();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

        goToNextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current_month > 12) {
                    reload(0, current_year + 1);
                } else {
                    reload(current_month + 1, current_year);
                }
            }
        });

        gotToPreviousMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current_month < 0) {
                    reload(11, current_year - 1);
                } else {
                    reload(current_month - 1, current_year);
                }
            }
        });
    }


    public void call() {
        this.adapter = new CustomAdapter(currentMonthPreferences, getApplicationContext());
        currentMonthPreferencesView.setAdapter((ListAdapter) adapter);
        currentMonthPreferencesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Preference preference = currentMonthPreferences.get(position);
                preference.lunch = !preference.lunch;
                adapter.notifyDataSetChanged();
            }
        });
    }


}









