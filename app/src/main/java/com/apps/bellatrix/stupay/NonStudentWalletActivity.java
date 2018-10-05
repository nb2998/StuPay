package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NonStudentWalletActivity extends AppCompatActivity {

    Button btnReceive;
    TextView tvAmount;
    int id;
    ImageButton btnTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_student_wallet);

        btnReceive = findViewById(R.id.btnReceive);
        tvAmount = findViewById(R.id.tvAmount);
        btnTransactions = findViewById(R.id.btnTransactions);
        id = getIntent().getIntExtra(getString(R.string.loginId), 21);

        btnTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transActionIntent = new Intent(NonStudentWalletActivity.this, TransactionsActivity.class);
                transActionIntent.putExtra(getString(R.string.loginId), id);
                startActivity(transActionIntent);
            }
        });

        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiveIntent = new Intent(NonStudentWalletActivity.this, ReceiveNonStudentActivity.class);
                receiveIntent.putExtra(getString(R.string.loginId), id);
                startActivity(receiveIntent);
            }
        });
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference().child("NonStudent");

        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(id ==4) {
                    long amt = (Long) dataSnapshot.child(String.valueOf(id)).child("-LO-JpcEZR4pmsODrOXQ").child("currentBalance").getValue();
                    tvAmount.setText("Current Balance: Rs. " + amt);
                } else if(id == 5) {
                    long amt = (Long) dataSnapshot.child(String.valueOf(id)).child("-LO-JpcFbf4nwo98GI6x").child("currentBalance").getValue();
                    tvAmount.setText("Current Balance: Rs. " + amt);
                } else {
                    tvAmount.setText("Current Balance: Rs. 205");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
