package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.apps.bellatrix.stupay.models.Student;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentWalletActivity extends AppCompatActivity{

    Button btnPay, btnReceive;
    TextView tvAmount;
    int id;
    ImageButton btnTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passbookstudent);

        btnPay = findViewById(R.id.btnPay);
        btnReceive = findViewById(R.id.btnReceive);
        btnTransactions = findViewById(R.id.btnTransactions);
        tvAmount = findViewById(R.id.tvAmount);

        id = getIntent().getIntExtra(getString(R.string.loginId), 21);

        btnTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transActionIntent = new Intent(StudentWalletActivity.this, TransactionsActivity.class);
                transActionIntent.putExtra(getString(R.string.loginId), id);
                startActivity(transActionIntent);
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payIntent = new Intent(StudentWalletActivity.this, ScannedBarcodeActivity.class);
                payIntent.putExtra(getString(R.string.loginId), id);
                startActivity(payIntent);
            }
        });

        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiveIntent = new Intent(StudentWalletActivity.this, ReceiveStudentActivity.class);
                receiveIntent.putExtra(getString(R.string.loginId), id);
                startActivity(receiveIntent);
            }
        });
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference().child("Student");

//        rootRef.addValueEventListener(this);
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(id ==24) {
                    long amt = (Long) dataSnapshot.child(String.valueOf(id)).child("-LO-JpcKGtMtWZuqnXOD").child("currentBalance").getValue();
                    tvAmount.setText("Current Balance: Rs. " + amt);
                } else if(id == 23) {
                    long amt = (Long) dataSnapshot.child(String.valueOf(id)).child("-LO-JpcJWPJ2CjM4tNu9").child("currentBalance").getValue();
                    tvAmount.setText("Current Balance: Rs. " + amt);
                } else {
                    tvAmount.setText("Current Balance: Rs. 203");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
