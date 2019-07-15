package com.example.dell.mobileq;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class show extends AppCompatActivity {
    ListView listView;
DatabaseReference ref;
FirebaseDatabase database;
    private FirebaseAuth mAuth;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    token t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mAuth = FirebaseAuth.getInstance();
        t = new token();
        listView  = (ListView) findViewById(R.id.listView);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("tokens");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.token1,R.id.name,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    t=ds.getValue(token.class);

                    list.add("The processing token is  "+t.getToken().toString());


                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
