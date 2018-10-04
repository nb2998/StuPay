package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceiveStudentActivity extends AppCompatActivity {

    Button btnProceedStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_student);

        btnProceedStudent = findViewById(R.id.btnProceedStudent);
        btnProceedStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmIntent = new Intent(ReceiveStudentActivity.this, ConfirmationActivity.class);
                startActivity(confirmIntent);
            }
        });
    }
}
