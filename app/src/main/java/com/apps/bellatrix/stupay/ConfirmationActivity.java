package com.apps.bellatrix.stupay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);
    }

    @Override
    public void onBackPressed() {
        Intent goBackToWalletIntent = new Intent(ConfirmationActivity.this, StudentWalletActivity.class);
        goBackToWalletIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        goBackToWalletIntent.putExtra(getString(R.string.loginId), getIntent().getIntExtra(getString(R.string.loginId), 23));
        startActivity(goBackToWalletIntent);
    }
}
