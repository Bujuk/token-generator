package com.example.dell.mobileq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity2 extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button buttonstarted;
    private Button show;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);



        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonstarted = (Button) findViewById(R.id.buttonstarted);
        show=(Button) findViewById(R.id.show);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome!!!");

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonstarted.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){

            //starting login activity
            startActivity(new Intent(this, choose_user.class));
        }

        if(view == show){
            startActivity(new Intent(this, show.class));
        }
    }
}
