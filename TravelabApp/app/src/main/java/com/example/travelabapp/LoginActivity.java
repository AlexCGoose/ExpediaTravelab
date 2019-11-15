package com.example.travelabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //Initialise email + password variables and login button
    private Button buttonLogIn;
    private EditText editTextEmail, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Relates variables to Design View
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogIn =  findViewById(R.id.buttonLogIn);

        //Listener will be used to change activities
        buttonLogIn.setOnClickListener(this);
    }

    private void userLogIn() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();

            Log.w("Login Activity", "User provided an invalid email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();

            Log.w("Login Activity", "User provided an invalid password");
            return;
        }
        //TODO: Login auth

        //Code here

        //TODO: After logging in, redirect to a home page of sorts
        //Start home page activity
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLogIn) {
            userLogIn();
        }
    }
}
