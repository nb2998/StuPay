package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceiveNonStudentActivity extends AppCompatActivity {

    Button btnProceedNonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_non_student);

        btnProceedNonStudent = findViewById(R.id.btnProceedNontudent);
        btnProceedNonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmIntent = new Intent(ReceiveNonStudentActivity.this, ConfirmationActivity.class);
                startActivity(confirmIntent);
            }
        });
    }
}
