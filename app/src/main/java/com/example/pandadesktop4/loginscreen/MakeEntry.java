package com.example.pandadesktop4.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.pandadesktop4.loginscreen.R.id.button;

public class MakeEntry extends AppCompatActivity {



    Button b;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_entry);


        b=(Button)findViewById(R.id.buttonb1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              i=new Intent(getApplicationContext(),PreferenceEntry.class);
                startActivity(i);
            }
        });
    }
}
