package com.apps.bellatrix.stupay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionsActivity extends AppCompatActivity {

    RecyclerView recViewTransac;
    ArrayList<Transaction> list = new ArrayList<>();
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        id = getIntent().getIntExtra(getString(R.string.loginId),id);

        if(id<20){
            list.add(new Transaction("Notes", 20, true));
            list.add(new Transaction("Printout", 50, true));
            list.add(new Transaction("Notes", 30, true));
            list.add(new Transaction("Notes", 50, true));

        } else{
            list.add(new Transaction("Canteen", 50, false));
            list.add(new Transaction("Sent to friend", 90, false));
            list.add(new Transaction("Received from friend", 120, true));
            list.add(new Transaction("Paid for IOT workshop", 150, false));
        }

        recViewTransac = findViewById(R.id.recViewTransac);
        recViewTransac.setLayoutManager(new LinearLayoutManager(TransactionsActivity.this));
        TransactionAdapter adapter = new TransactionAdapter(list, this);
        recViewTransac.setAdapter(adapter);

    }
}
