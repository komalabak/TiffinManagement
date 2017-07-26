package com.example.pandadesktop4.loginscreen;

import android.graphics.Color;
//import android.icu.util.Calendar;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PreferenceEntry extends AppCompatActivity {

    String monthNames[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","October","Nov","Dec"};;
    String dayNames[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    Calendar myCalender;
    int current_month=0;
    int current_day = 0;
    private Button btn;
    ArrayList dataModels[];
    ArrayList myModel;
    ListView listView;
    private CustomAdapter adapter;
    Button nextbutton,previousb;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_entry);
//        myCalender = new GregorianCalendar(2017, 1, 1);
        dataModels = new ArrayList[12];
        listView = (ListView) findViewById(R.id.listView);
//        listView = new ListView[12];
        for(int i=0;i<12;i++){
            dataModels[i] = new ArrayList();
//            listView[i] = (ListView) findViewById(R.id.listView);
        }
        Log.i("deb","app initiated#####################");
        current_day = 6;
        current_month = 0;
//        listView = (ListView) findViewById(R.id.listView);
        nextbutton = (Button) findViewById(R.id.nextbutton);
        previousb = (Button) findViewById(R.id.previousbutton);
        txt = (TextView) findViewById(R.id.monthtext);
        Log.i("deb","app LOOP STARTED#####################");
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_month++;
                if (current_month >= 12) {
                    current_month = 11;
                }
                adapter = new CustomAdapter(dataModels[current_month], getApplicationContext());
                call();
                txt.setText(monthNames[current_month]);


            }
        });

        previousb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_month--;
                if (current_month <= 0) {
                    current_month = 0;
                }
                adapter = new CustomAdapter(dataModels[current_month], getApplicationContext());
                txt.setText(monthNames[current_month]);
                call();


            }
        });


        String my = "/2017";

        for (int i = 0; i < 12; i++) {
            for (int j = 1; j <= 31; j++) {
                Log.i("deb",Integer.toString(i)+ " " + Integer.toString(j));
                dataModels[i].add(new DataModel(Integer.toString(j) + "/" + Integer.toString(i+1) + my + " - " + dayNames[j%7], false));
            }
        }
        Log.i("deb","FOR LOOP STARTED#####################");

//        for(int i=1;i<=31;i++){
//            current_day = current_day % 7;
//            myModel.add(new DataModel(Integer.toString(i)+my + " - " + dayNames[current_day],false));
//            current_day++;
//        }
        Log.i("deb","FOR LOOP END initiated#####################");

//        dataModels.add(new DataModel("1/07/2017",false));
//
//        dataModels.add(new DataModel("2/07/2017",false));
//        dataModels.add(new DataModel("3/07/2017",false));
//        dataModels.add(new DataModel("4/07/2017",false));
//        dataModels.add(new DataModel("5/07/2017",false));
//        dataModels.add(new DataModel("6/07/2017",false));
//        dataModels.add(new DataModel("7/07/2017",false));
//        dataModels.add(new DataModel("8/07/2017",false));
//
//        dataModels.add(new DataModel("9/07/2017",false));
//        dataModels.add(new DataModel("10/07/2017",false));
//        dataModels.add(new DataModel("11/07/2017",false));
//        dataModels.add(new DataModel("12/07/2017",false));
//        dataModels.add(new DataModel("13/07/2017",false));
//        //dataModels.add(new DataModel("1",false));
//
//
//        dataModels.add(new DataModel("14/07/2017",false));
//
//        dataModels.add(new DataModel("15/07/2017",false));
//        dataModels.add(new DataModel("16/07/2017",false));
//        dataModels.add(new DataModel("17/07/2017",false));
//        dataModels.add(new DataModel("18/07/2017",false));
//        dataModels.add(new DataModel("19/07/2017",false));
//        dataModels.add(new DataModel("20/07/2017",false));
//        dataModels.add(new DataModel("21/07/2017",false));
//
//        dataModels.add(new DataModel("22/07/2017",false));
//        dataModels.add(new DataModel("23/07/2017",false));
//        dataModels.add(new DataModel("24/07/2017",false));
//        dataModels.add(new DataModel("25/07/2017",false));
//        dataModels.add(new DataModel("26/07/2017",false));
//        dataModels.add(new DataModel("27/07/2017",false));
//
//        dataModels.add(new DataModel("28/07/2017",false));
//
//        dataModels.add(new DataModel("29/07/2017",false));
//        dataModels.add(new DataModel("30/07/2017",false));
//        dataModels.add(new DataModel("31/07/2017",false));


        adapter = new CustomAdapter(dataModels[current_month], getApplicationContext());
        call();


    }

    public static int getMaxDays(Calendar myCal,int month) {
        return myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public void call()
    {
        listView.setAdapter((ListAdapter) adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                DataModel dataModel = (DataModel) dataModels[current_month].get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();


            }
        });
    }
    }








