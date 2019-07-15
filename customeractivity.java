package com.example.dell.mobileq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

import static android.R.attr.key;


public class customeractivity extends AppCompatActivity {

    //User INPUT values
    private String Comment;
    private String TIME;

    private DatabaseReference mDatabaseReference;
    //Updated Values
    private String OldToken;

    //constructor
    customeractivity(String Com,String tim,String Oldtok){

        Comment=Com;
        TIME=tim;
        OldToken=Oldtok;

    }
    customeractivity(){

    }

    public String getComment() {
        return Comment;
    }

    public String getTIME() {
        return TIME;
    }

    public String getOldToken() {
        return OldToken;
    }
}
