package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apps.bellatrix.stupay.models.NonStudent;
import com.apps.bellatrix.stupay.models.Student;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity{

    Button btnLogin;
    EditText etId, etPwd;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        etPwd = findViewById(R.id.etPwd);
        etId = findViewById(R.id.etId);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etId.getText().toString().trim().length() != 0) {
                    id = Integer.valueOf(etId.getText().toString());
                    if (id < 20) {
                        Intent nonstudentIntent = new Intent(LoginActivity.this, NonStudentWalletActivity.class);
                        nonstudentIntent.putExtra(getString(R.string.loginId), id);
                        startActivity(nonstudentIntent);

                    } else {
                        Intent studentIntent = new Intent(LoginActivity.this, StudentWalletActivity.class);
                        studentIntent.putExtra(getString(R.string.loginId), id);
                        startActivity(studentIntent);

                    }
                }
            }
        });

//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference ref = firebaseDatabase.getReference();
//
//        NonStudent ns1 = new NonStudent(1, "Canteen", 1000);
//        ref.child("NonStudent").child("1").setValue(ns1);
//        NonStudent ns2 = new NonStudent(2, "Photostat", 250);
//        NonStudent ns3 = new NonStudent(3, "Literary-Society", 100);
//        NonStudent ns4 = new NonStudent(4, "Hostel mess", 200);
//        NonStudent ns5 = new NonStudent(5, "Nescafé", 200);
//        ref.child("NonStudent").child("2").push().setValue(ns2);
//        ref.child("NonStudent").child("3").push().setValue(ns3);
//        ref.child("NonStudent").child("4").push().setValue(ns4);
//        ref.child("NonStudent").child("5").push().setValue(ns5);
//
//        Student s1 = new Student(21, "Nishtha", "01001012016", 100);
//        ref.child("Student").child("21").setValue(s1);
//        Student s2 = new Student(22, "Aakarshita", "02001012016", 100);
//        Student s3 = new Student(23, "Prerna", "03001012016", 100);
//        Student s4 = new Student(24, "Dilsheen", "04001012016", 100);
//        ref.child("Student").child("22").push().setValue(s2);
//        ref.child("Student").child("23").push().setValue(s3);
//        ref.child("Student").child("24").push().setValue(s4);
    }
}
