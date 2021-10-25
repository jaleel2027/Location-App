package com.example.locationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity{

    EditText regName;
    EditText regEmail;
    EditText regPassword;
    Button regButton;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

         regName= findViewById(R.id.id_reg_name);
         regEmail= findViewById(R.id.id_reg_name);
         regPassword= findViewById(R.id.id_reg_name);
         regButton= findViewById(R.id.reg_button);

        sharedPreferences= getSharedPreferences("USERINFO",MODE_PRIVATE);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To generate data:
                String newRegName= regName.getText().toString();
                String newRegEmail=regEmail.getText().toString();
                String newRegPassword= regPassword.getText().toString();


                //TO open the file to preferences:

                if (regName.length()>1) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("regName", newRegName);
                    editor.putString("regEmail", newRegEmail);
                    editor.putString("regPassword", newRegPassword);
                    editor.apply();
                    Toast.makeText(Register.this, "User registered Successfully", Toast.LENGTH_SHORT).show();

                    Intent intentToMain = new Intent(Register.this, MainActivity.class);
                    startActivity(intentToMain);

                }
                else {
                    Toast.makeText(Register.this, "Enter Details", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

}


