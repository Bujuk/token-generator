package com.example.dell.mobileq;

import android.content.Intent;
import android.media.session.MediaSession;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class employeestart extends AppCompatActivity {

    EditText text;
    String Token;
    Button btn;
    DatabaseReference ref;
    FirebaseDatabase database;
    int flag=0;
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeestart);
       textView10=(TextView)findViewById(R.id.textView10);
       text=(EditText)findViewById(R.id.text);
       btn=(Button)findViewById(R.id.btn);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("CodesAcc").child("ttt");
        Query query=ref.orderByKey().limitToFirst(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        String message = ds.child("Token").getValue().toString();
                        textView10.setText("The token number to complete is " + message);



                    }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public void process(View view)
    {
       String token=text.getText().toString();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query applesQuery = ref.child("CodesAcc").child("ttt").orderByChild("Token").equalTo(token);
        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        Intent j = new Intent(employeestart.this, employeeactivity.class);
        startActivity(j);

    }
}