package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps.bellatrix.stupay.models.NonStudent;

public class ConfirmationActivity extends AppCompatActivity {

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);
        id = getIntent().getIntExtra(getString(R.string.loginId), 23);
    }

    @Override
    public void onBackPressed() {

        if(id<20) {
            Intent goBackToWalletIntent = new Intent(ConfirmationActivity.this, NonStudentWalletActivity.class);
            goBackToWalletIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            goBackToWalletIntent.putExtra(getString(R.string.loginId), id);
            startActivity(goBackToWalletIntent);
        } else{
            Intent goBackToWalletIntent = new Intent(ConfirmationActivity.this, StudentWalletActivity.class);
            goBackToWalletIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            goBackToWalletIntent.putExtra(getString(R.string.loginId), id);
            startActivity(goBackToWalletIntent);
        }
    }
}
