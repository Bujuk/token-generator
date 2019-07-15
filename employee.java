package com.example.dell.mobileq;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class employee extends AppCompatActivity {
    EditText token1;
    Button buttonprocess;
    DatabaseReference databaseReference;
    DataSnapshot dsp;
    private FirebaseAuth mAuth;
    TextView mes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        token1=(EditText) findViewById(R.id.token1);
        buttonprocess=(Button) findViewById(R.id.buttonprocess);
        mes=(TextView)findViewById(R.id.mes);



    }
    private void sendSMS(String phoneNumber,String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
        public void start(View view)
    {
        String number=token1.getText().toString();
        String  phone="Ac" + (Integer.parseInt(number.substring(2)) + 4);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("CodesAcc").child("ttt");
        Query query=ref.orderByChild("Token").equalTo(phone);
        query.addValueEventListener(new ValueEventListener() {
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
        String tokenno=token1.getText().toString().trim();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference token=firebaseDatabase.getReference().child("tokens").child("tokenno");
        token reg=new token(tokenno);
        token.setValue(reg);
        Toast.makeText(this,"Customer is processing",Toast.LENGTH_LONG).show();



    }


}
