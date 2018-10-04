package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentWalletActivity extends AppCompatActivity {

    Button btnPay, btnReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passbookstudent);

        btnPay = findViewById(R.id.btnPay);
        btnReceive = findViewById(R.id.btnReceive);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payIntent = new Intent(StudentWalletActivity.this, ScannedBarcodeActivity.class);
                startActivity(payIntent);
            }
        });

        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiveIntent = new Intent(StudentWalletActivity.this, ReceiveActivity.class);
                startActivity(receiveIntent);
            }
        });
    }
}
