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

public class ReceiveNonStudentActivity extends AppCompatActivity {

    Button btnProceedNonStudent;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_non_student);

        id = getIntent().getIntExtra(getString(R.string.loginId), 4);

        btnProceedNonStudent = findViewById(R.id.btnProceedNontudent);
        btnProceedNonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmIntent = new Intent(ReceiveNonStudentActivity.this, ConfirmationActivity.class);
                confirmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                confirmIntent.putExtra(getString(R.string.loginId), id);


                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference ref = firebaseDatabase.getReference();

                final String unique;
                if(id == 4) unique = "-LO-JpcEZR4pmsODrOXQ";
                else unique = "-LO-JpcFbf4nwo98GI6x";

                final DatabaseReference curr = ref.child("NonStudent").child(String.valueOf(id)).child(unique);
                Log.d("TAG", "onClick: "+curr);

                curr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot!=null) {
                            long currBal = (Long) dataSnapshot.child("currentBalance").getValue();
                            Log.d("TAG", "onDataChange: " + currBal);
                            currBal += 20;

                            ref.child("NonStudent").child(String.valueOf(id)).child(unique).child("currentBalance").setValue(currBal);

                        } else {
                            Log.d("TAG", "onDataChange: " + null);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                startActivity(confirmIntent);
            }
        });
    }
}
