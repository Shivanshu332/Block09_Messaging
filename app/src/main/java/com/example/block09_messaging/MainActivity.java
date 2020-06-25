package com.example.block09_messaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtMsg= findViewById(R.id.txtMsg);
        final EditText txtNum= findViewById(R.id.txtNumber);
        Button btnSend= findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= txtMsg.getText().toString();
                String number= txtNum.getText().toString();
                Uri destination= Uri.parse("smsto:5885"+number);
                Intent sms_Intent = new Intent(Intent.ACTION_SENDTO, destination);
                sms_Intent.putExtra("sms_body", message);
                startActivity(sms_Intent);
            }
        });
    }
}