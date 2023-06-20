package com.example.basicbankingapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;

import java.text.NumberFormat;

public class UserProfileActivity extends AppCompatActivity {

    private UsersClass usersClass;

    private TextView txtName;
    private TextView txtAccountNo;
    private TextView txtPhoneNo;
    private TextView txtAccountBal;

    private Button btnTransferMoney;
    public double operationResult;

    public static final String  TRANSFER_OBJECT_KEY = "TRANSFER_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        usersClass = (UsersClass) getIntent().getSerializableExtra(UsersActivity.USER_OBJECT_KEY);
        setTitle("User Profile");

        txtName = (TextView) findViewById(R.id.txtName);
        txtAccountNo = (TextView) findViewById(R.id.txtAccountNo);
        txtPhoneNo = (TextView) findViewById(R.id.txtPhoneNumber);
        txtAccountBal = (TextView) findViewById(R.id.txtAccountBalance);

        btnTransferMoney = (Button) findViewById(R.id.btnTransferMoney);

        txtName.setText(usersClass.getUserName());
        txtAccountNo.setText(usersClass.getUserAccount());
        String balanceFormatted = NumberFormat.getCurrencyInstance().format(usersClass.getUserBalance());
        String phoneNoFormatted = PhoneNumberUtils.formatNumber(usersClass.getUserPhoneNumber());
        txtPhoneNo.setText(phoneNoFormatted);
        txtAccountBal.setText(balanceFormatted);

        btnTransferMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, SendToActivity.class);
                intent.putExtra(TRANSFER_OBJECT_KEY,usersClass);
                startActivity(intent);
                finish();
            }
        });
    }

}