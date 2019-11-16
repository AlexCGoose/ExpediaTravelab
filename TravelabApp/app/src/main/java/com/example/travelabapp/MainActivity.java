package com.example.travelabapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button newGroup;
    Button createGroup;
    ImageButton settings;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code block for determing user login status
        firebaseAuth = firebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference();

        createGroup = (Button) findViewById(R.id.btn1);
        settings =  (ImageButton) findViewById(R.id.btnSettings);

        createGroup.setOnClickListener(this);
        settings.setOnClickListener(this);


        //TODO create newGroup buttons accessors user's existing groups

    }

    @Override
    public void onClick(View view) {
        //startActivity(new Intent(this, MainActivity.class));
        if(view == createGroup) {
            if(createGroup.getText().toString().equals("New Group"))
            {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                LinearLayout layout = (LinearLayout) findViewById(R.id.groupsLayout);
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref2 = ref.child("Users").child(user.getUid()).child("name");

                ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.getValue(String.class);
                        //do what you want with the email
                        createGroup.setText(name + "'s Holiday Group");

                        //TODO declare new group to user's dataset

                        //Here we can use editTextGroup to set the name of the group
                        //String groupName = editTextGroup.getText().toString().trim();

                        String groupName = name + "Group";

                        //Set group name to his display name
                        //Group is named after the person who creates it, and he is set as first member.
                        //GroupInformation groupInformation = new GroupInformation(user.getDisplayName(), user.getDisplayName());
                        databaseReference.child("Users").child(user.getUid()).child("Group").setValue(groupName);
                        databaseReference.child("Groups").child(groupName).child("Members").child("1").setValue(name);
                        databaseReference.child("Groups").child(groupName).child("MemCount").setValue("1");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            else
            {
                Log.e("TAG", createGroup.getText().toString());
                finish();
                startActivity(new Intent(this, GroupActivity.class));
            }
        }

        if(view == settings) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }
}
