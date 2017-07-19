package com.example.pandadesktop4.loginscreen;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
    EditText ed1,ed2;

    TextView txt1;
    int counter=3;
   // Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);



       // b2=(Button)findViewById(R.id.button2);
        txt1=(TextView)findViewById(R.id.textView6);
        txt1.setVisibility(View.GONE);




        b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                if (ed1.getText().toString().trim().length() <=0  )
                {
                    Toast.makeText(getApplicationContext(),"Enter Username",Toast.LENGTH_SHORT).show();
                }
                else if (ed2.getText().toString().trim().length() <=0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
                }
                 if(ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Redirecting....",Toast.LENGTH_SHORT).show();
                    Intent  i = new Intent(getApplicationContext(), MakeEntry.class);
                    startActivity(i);
                }
                 else{


                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
                    txt1.setVisibility(View.VISIBLE);
                    txt1.setBackgroundColor(Color.RED);
                    counter--;
                    txt1.setText(Integer.toString(counter));

                    if(counter == 0){
                        b1.setEnabled(false);
                    }
                }
            }

        });




    }
}
