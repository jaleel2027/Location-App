package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText loginName;
    private EditText loginPassword;
    private TextView regHere;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginName = (EditText) findViewById(R.id.id_name);
        loginPassword= (EditText) findViewById(R.id.id_Password);
        loginButton = (Button) findViewById(R.id.login_button);
        regHere= (TextView) findViewById(R.id.id_regHere);

        sharedPreferences= getSharedPreferences("USERINFO",MODE_PRIVATE);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName= loginName.getText().toString();
                String password= loginPassword.getText().toString();

                String registeredName= sharedPreferences.getString("regName","");
                String registeredPassword= sharedPreferences.getString("regPassword","");

                if (userName.equals(registeredName)&&password.equals(registeredPassword)){
                    Intent intentToData = new Intent(MainActivity.this,DataInfo.class);
                    startActivity(intentToData);
                }

            }
        });

        Intent intentToData = new Intent(MainActivity.this,DataInfo.class);
        startActivity(intentToData);


        regHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intentToReg = new Intent(MainActivity.this,Register.class);
              startActivity(intentToReg);

            }
        });

    }
}