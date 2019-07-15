package com.example.dell.mobileq;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class employeeactivity extends AppCompatActivity {
    TextView textView4;
    Button buttonprocess;
    private FirebaseAuth firebaseAuth;
    Button buttoncomplete;
    Button b1;
    ListView listView;
    DatabaseReference ref;
    FirebaseDatabase database;
    private FirebaseAuth mAuth;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    int flag=1;
    user t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeeactivity);
        textView4=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.bu);
        t = new user();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("CodesAcc").child("ttt");
        Query query=ref.orderByKey().limitToFirst(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    String message=ds.child("Token").getValue().toString();
                    textView4.setText("The token to be processed is "+message);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }



    public void start(View view) {

        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("CodesAcc").child("ttt");
        Query query=ref.orderByKey().limitToFirst(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        if(flag==1) {
                        String message = ds.child("Token").getValue().toString();
                        process(message);


                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void delete(View view) {
        Intent i = new Intent(employeeactivity.this, employeestart.class);
        startActivity(i);
    }
    public void process(String message)
    {
        flag=0;

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference token=firebaseDatabase.getReference().child("tokens").child("tokenno");
        token reg=new token(message);
        token.setValue(reg);
        String  phone="Ac" + (Integer.parseInt(message.substring(2)) + 4);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("CodesAcc").child("ttt");
        Query query=ref.orderByChild("Token").equalTo(phone);
     query.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             for(DataSnapshot ds:dataSnapshot.getChildren()){


                 String message=ds.child("Phone_no").getValue().toString();
                 final String saran="9659340296";
                 SmsManager sms=SmsManager.getDefault();
                 sms.sendTextMessage(message,saran,"ALERT:" +
                         "You are behind 4.....Your turn is going to arrive....." +
                         "Please make your presence on time",null,null);

             }
         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });
        Intent j = new Intent(employeeactivity.this, employeeactivity.class);
        startActivity(j);


    }
    public void del(String message)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query applesQuery = ref.child("CodesAcc").child("ttt").orderByChild("Token").equalTo(message);
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

    }
    public void customer1(View v) {
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null


        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        firebaseAuth.signOut();
        //closing activity
        finish();

        Intent j = new Intent(employeeactivity.this, choose_user.class);
        startActivity(j);
    }
}
