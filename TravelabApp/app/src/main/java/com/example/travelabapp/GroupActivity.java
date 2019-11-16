package com.example.travelabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;

import com.google.firebase.auth.FirebaseAuth;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonMessage;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        buttonMessage = (ImageButton) findViewById(R.id.messageButton);
        buttonMessage.setOnClickListener(this);

        firebaseAuth = firebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if(view == buttonMessage) {
            finish();
            startActivity(new Intent(this, MessageActivity.class));;
        }
    }
}
