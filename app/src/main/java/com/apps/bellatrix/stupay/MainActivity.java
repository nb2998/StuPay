package com.apps.bellatrix.stupay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps.bellatrix.stupay.models.NonStudent;
import com.apps.bellatrix.stupay.models.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference ref = firebaseDatabase.getReference();
//
//        NonStudent ns1 = new NonStudent(1, "Canteen", 1000);
//        ref.child("NonStudent").setValue(ns1);
////        NonStudent ns2 = new NonStudent(2, "Photostat", 250);
////        NonStudent ns3 = new NonStudent(3, "Literary-Society", 100);
//
//        Student s1 = new Student(21, "Nishtha", "01001012016", 100);
//        ref.child("Student").setValue(s1);
////        Student s2 = new Student(22, "Aakarshita", "02001012016", 100);
////        Student s3 = new Student(23, "Prerna", "03001012016", 100);
////        Student s4 = new Student(24, "Dilsheen", "04001012016", 100);