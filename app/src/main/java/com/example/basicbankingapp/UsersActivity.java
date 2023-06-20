package com.example.basicbankingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;

import com.example.basicbankingapp.ModelForUserDataBase.UsersDataBase;
import com.example.basicbankingapp.RecyclerForUser.AllUserAdapter;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.databinding.ActivityUsersBinding;

import java.io.Serializable;

public class UsersActivity extends AppCompatActivity implements AllUserAdapter.UserIsClickedInterface  {

    private AppBarConfiguration appBarConfiguration;
    private ActivityUsersBinding binding;
    private RecyclerView allUserRecyclerView;

    private UsersDataBase usersDataBase;

    public static final String  USER_OBJECT_KEY = "USER_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        usersDataBase = new UsersDataBase(UsersActivity.this);


        if(usersDataBase.returnAllUsersDetails().size()==0) {
            usersDataBase.addUserToDatabase();
        }
        allUserRecyclerView = findViewById(R.id.user_recyceler_view);
        allUserRecyclerView.setAdapter(new AllUserAdapter(usersDataBase.returnAllUsersDetails(),this));

        allUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }



    public void displayUserProfile(UsersClass usersClass) {
        Intent userItemsIntent = new Intent(this, UserProfileActivity.class);
        userItemsIntent.putExtra(USER_OBJECT_KEY,usersClass);
        startActivity(userItemsIntent);
    }



    @Override
    public void userIsClicked(UsersClass usersClass) {
        displayUserProfile(usersClass);
    }

    @Override
    protected void onResume() {
        super.onResume();
        modifyUserInterface();
    }
    private void modifyUserInterface(){
        allUserRecyclerView = findViewById(R.id.user_recyceler_view);
        allUserRecyclerView.setAdapter(new AllUserAdapter(usersDataBase.returnAllUsersDetails(),this));

        allUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}