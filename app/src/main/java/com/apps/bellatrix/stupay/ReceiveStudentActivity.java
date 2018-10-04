package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReceiveStudentActivity extends AppCompatActivity {

    Button btnProceedStudent;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_student);

        btnProceedStudent = findViewById(R.id.btnProceedStudent);

        id = getIntent().getIntExtra(getString(R.string.loginId), 23);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference ref = firebaseDatabase.getReference();
        final DatabaseReference curr = ref.child("Student").child(String.valueOf(id)).child("-LO-JpcJWPJ2CjM4tNu9");

        btnProceedStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmIntent = new Intent(ReceiveStudentActivity.this, ConfirmationActivity.class);
                curr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot!=null) {
                            long currBal = (Long) dataSnapshot.child("currentBalance").getValue();
                            Log.d("TAG", "onDataChange: " + currBal);
                            currBal += 20;

                            ref.child("Student").child(String.valueOf(id)).child("-LO-JpcJWPJ2CjM4tNu9").child("currentBalance").setValue(currBal);

                        } else {
                            Log.d("TAG", "onDataChange: " + null);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                confirmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                confirmIntent.putExtra(getString(R.string.loginId), id);
                startActivity(confirmIntent);
            }
        });
    }
}
