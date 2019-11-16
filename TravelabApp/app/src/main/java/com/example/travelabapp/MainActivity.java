package com.example.travelabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button newGroup;
    Button createGroup;
    ImageButton settings;
    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code block for determing user login status
        firebaseAuth = firebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }


        createGroup = (Button) findViewById(R.id.btn1);
        settings =  (ImageButton) findViewById(R.id.btnSettings);

        createGroup.setOnClickListener(this);
        settings.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
        if(view == createGroup) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            LinearLayout layout = (LinearLayout) findViewById(R.id.rootLayout);
            newGroup = new Button(this);
            newGroup.setText(user.getDisplayName() + "'s Holiday Group");
            layout.addView(newGroup);
            //Add new group to user's dataset
        }

        if(view == settings) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }
}
