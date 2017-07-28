package com.example.pandadesktop4.loginscreen.screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pandadesktop4.loginscreen.R;
import com.example.pandadesktop4.loginscreen.repo.LoginAPI;
import com.example.pandadesktop4.loginscreen.repo.RestClient;
import com.example.pandadesktop4.loginscreen.repo.ServerResponse;
import com.example.pandadesktop4.loginscreen.ro.LoginRequest;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    Button loginButton, b2;
    EditText username, password;

    TextView usernametext;
    int counter = 3;

    // Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        JodaTimeAndroid.init(this);


        loginButton = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);


        // b2=(Button)findViewById(R.id.button2);
        usernametext = (TextView) findViewById(R.id.textView6);
        usernametext.setVisibility(View.GONE);
        username.setText("komal");
        password.setText("1234");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("----->", "Login Button CLicked");
                LoginAPI loginAPI = RestClient.getRestAdapter().create(LoginAPI.class);

                loginAPI.login(new LoginRequest(username.getText().toString(), password.getText().toString()), new Callback<ServerResponse>() {

//                    @Override
//                    public void success(LoginResponse loginResponse, Response response) {
//                        Toast.makeText(getApplicationContext(), "Redirecting....", Toast.LENGTH_SHORT).show();
//                        RestClient.authToken = loginResponse.getAuthToken();
//                        Intent i = new Intent(getApplicationContext(), MakeEntry.class);
//                        startActivity(i);
//                    }

                    @Override
                    public void success(ServerResponse serverResponse, Response response) {

                        RestClient.authToken = serverResponse.getAuthToken();
                        Intent i = new Intent(getApplicationContext(), MakeEntry.class);
                        startActivity(i);

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (error.getResponse().getStatus() == 400) {

                            Toast.makeText(getApplicationContext(), "Username or password incorrect.", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

            }
        });

//        loginButton.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v){
//                if (username.getText().toString().trim().length() <=0  )
//                {
//                    Toast.makeText(getApplicationContext(),"Enter Username",Toast.LENGTH_SHORT).show();
//                }
//                else if (password.getText().toString().trim().length() <=0)
//                {
//                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
//                }
//                 if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                    Toast.makeText(getApplicationContext(),"Redirecting....",Toast.LENGTH_SHORT).show();
//                    Intent  i = new Intent(getApplicationContext(), MakeEntry.class);
//                    startActivity(i);
//                }
//                 else{
//
//
//                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
//                    usernametext.setVisibility(View.VISIBLE);
//                    usernametext.setBackgroundColor(Color.RED);
//                    counter--;
//                    usernametext.setText(Integer.toString(counter));
//
//                    if(counter == 0){
//                        loginButton.setEnabled(false);
//                    }
//                }
//            }
//        });


    }
}
