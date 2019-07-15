package com.example.dell.mobileq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class adminpage extends AppCompatActivity {
    EditText email;
    Button insert;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);
        email=(EditText) findViewById((R.id.email));
        insert=(Button) findViewById((R.id.insert));

    }

    public void addemp(View view)
    {
        String emailid=email.getText().toString().trim();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference users=firebaseDatabase.getReference().child("customers").child("emailid");
        users reg=new users(emailid);
        users.setValue(reg);
        finish();
    }





}
