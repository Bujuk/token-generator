package com.example.dell.mobileq;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;


public class user extends AppCompatActivity {

    //User INPUT values
    public String Comment;

    public user(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    @Override
    public String toString() {
        return "user{" +
                "phoneno='" + phoneno + '\'' +
                '}';
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String phoneno;

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public void setOldToken(String Token) {
        Token = Token;
    }

    public String TIME;

    public DatabaseReference mDatabaseReference;
    //Updated Values
    public   String Token;

    //constructor
    user(String Com, String tim, String Oldtok,String number){

        Comment=Com;
        TIME=tim;
        Token=Oldtok;
        phoneno=number;

    }
    public user(){

    }



    public String getComment() {
        return Comment;
    }

    public String getTIME() {
        return TIME;
    }

    public  String getOldToken() {
        return Token;
    }
}
