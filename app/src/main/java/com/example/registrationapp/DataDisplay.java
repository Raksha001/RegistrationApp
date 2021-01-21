package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.telephony.SmsManager;
import android.widget.Toast;

public class DataDisplay extends AppCompatActivity {
    TextView t;
    String s1,num;
    SmsManager smsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        t = findViewById(R.id.textView3);

        s1 = getIntent().getStringExtra("abc");
        num = getIntent().getStringExtra("key");
        t.setText(s1);
    }

    public void sends(View view) {
        smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, "Details Received!", null, null);
       /* SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("phoneNo", null, "Details Received!", null, null);*/
        Toast.makeText(this, "Sms Send successfully!", Toast.LENGTH_SHORT).show();
    }
}