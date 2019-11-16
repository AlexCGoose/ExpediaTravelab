package com.example.travelabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //Initialise email + password variables and login button
    private Button buttonSignIn;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Relates variables to Design View
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignup);
        progressDialog = new ProgressDialog(this);

        //Listener will be used to change activities
        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
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
        //If validations are ok
        //Show a progress bar
        progressDialog.setMessage("Signing in...");
        progressDialog.show();

        //TODO: Login auth

        //Code here

        //TODO: After logging in, redirect to a home page of sorts
        //Start home page activity
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignIn) {
            userLogIn();
        }
        if(view == textViewSignUp) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
