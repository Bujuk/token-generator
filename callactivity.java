

package com.example.dell.mobileq;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class callactivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:9488677921" +
                ""));
        if(ActivityCompat.checkSelfPermission(callactivity.this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(callIntent);
    }
}

