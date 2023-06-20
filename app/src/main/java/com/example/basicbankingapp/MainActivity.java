package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnUser, btnTransactionHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUser =  findViewById(R.id.btnUsers);
        btnTransactionHistory = findViewById(R.id.btnTransactionHistory);

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, UsersActivity.class);
                startActivity(intent);
            }
        });
        btnTransactionHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,TransactionActivity.class);
                startActivity(intent);
            }
        });

    }
}