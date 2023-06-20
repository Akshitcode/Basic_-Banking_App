package com.example.basicbankingapp;

import android.os.Bundle;

import com.example.basicbankingapp.ModelForTransactionDatabase.TransactionClass;
import com.example.basicbankingapp.ModelForTransactionDatabase.TransactionDatabase;
import com.example.basicbankingapp.RecyclerForTransactionHistory.TransactionAdapter;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.databinding.ActivityTransactionBinding;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTransactionBinding binding;
    private RecyclerView recyclerView;
    private TransactionDatabase transactionDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTransactionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        transactionDatabase = new TransactionDatabase(TransactionActivity.this);
        ArrayList<TransactionClass> transactionClasses = transactionDatabase.returnAllTransactionHistory();

        recyclerView = findViewById(R.id.transactionRecyclerView);
        recyclerView.setAdapter( new TransactionAdapter(transactionClasses));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}