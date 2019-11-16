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
    private Button budgetButton;
    private Button locationButton;
    private Button flightsButton;
    private Button accomidationButton;
    private Button eventsButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        buttonMessage = (ImageButton) findViewById(R.id.messageButton);
        buttonMessage.setOnClickListener(this);

        budgetButton = (Button) findViewById(R.id.budgetButton);
        budgetButton.setOnClickListener(this);

        locationButton = (Button) findViewById(R.id.locationButton);
        locationButton.setOnClickListener(this);

        flightsButton = (Button) findViewById(R.id.flightsButton);
        flightsButton.setOnClickListener(this);

        accomidationButton = (Button) findViewById(R.id.accomidationButton);
        accomidationButton.setOnClickListener(this);

        eventsButton = (Button) findViewById(R.id.eventsButton);
        eventsButton.setOnClickListener(this);

        firebaseAuth = firebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if(view == buttonMessage) {
            finish();
            startActivity(new Intent(this, MessageActivity.class));;
        }

        if(view == budgetButton) {
            finish();
            startActivity(new Intent(this, BudgetActivity.class));;
        }

        if(view == locationButton) {
            finish();
            startActivity(new Intent(this, LocationActivity.class));;
        }

        if(view == flightsButton) {
            finish();
            startActivity(new Intent(this, FlightsActivity.class));;
        }

        if(view == accomidationButton) {
            finish();
            startActivity(new Intent(this, AccomidationActivity.class));;
        }

        if(view == eventsButton) {
            finish();
            startActivity(new Intent(this, EventsActivity.class));;
        }
    }
}
