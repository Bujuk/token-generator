package com.example.dell.mobileq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choose_user extends AppCompatActivity {
    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                admin(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employee(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer(v);
            }
        });
    }

    public void admin(View v) {
        Intent i = new Intent(choose_user.this, adminlogin.class);
        startActivity(i);
    }
    public void employee(View v) {
        Intent j = new Intent(choose_user.this, employeelogin.class);
        startActivity(j);
    }
    public void customer(View v) {
        Intent j = new Intent(choose_user.this, ProfileActivity2.class);
        startActivity(j);
    }

}
