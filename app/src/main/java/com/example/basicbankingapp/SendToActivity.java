package com.example.basicbankingapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;
import com.example.basicbankingapp.ModelForUserDataBase.UsersDataBase;
import com.example.basicbankingapp.RecyclerForSendTo.SendToAdapter;

import java.util.ArrayList;

public class SendToActivity extends AppCompatActivity implements SendToAdapter.ReceiverIsSelectedInterface {

    UsersClass usersClass1;
    private RecyclerView sendtorecyclerView;
    private UsersDataBase usersDataBase;
    public static final String  TRANSFER_TO_OBJECT_KEY = "TRANSFER_TO_KEY";
    public static final String  SENDER_OBJECT_KEY = "SENDER_KEY";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to);

        usersClass1 = (UsersClass) getIntent().getSerializableExtra(UserProfileActivity.TRANSFER_OBJECT_KEY);

        usersDataBase =new UsersDataBase(SendToActivity.this);
        ArrayList<UsersClass> usersClasses = usersDataBase.returnAllUsersDetails();
        sendtorecyclerView = findViewById(R.id.sendtoRecyclerView);
        sendtorecyclerView.setAdapter(new SendToAdapter(usersClasses,this));

        sendtorecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void ReceiverIsClicked(UsersClass usersClass) {
        Intent intent = new Intent(SendToActivity.this, TransferMoneyPageActivity.class);
        intent.putExtra(TRANSFER_TO_OBJECT_KEY,usersClass);
        intent.putExtra(SENDER_OBJECT_KEY, usersClass1);
        startActivity(intent);
        finish();
    }

}