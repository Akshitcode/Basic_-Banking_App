package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicbankingapp.ModelForTransactionDatabase.TransactionClass;
import com.example.basicbankingapp.ModelForTransactionDatabase.TransactionDatabase;
import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;
import com.example.basicbankingapp.ModelForUserDataBase.UsersDataBase;

public class TransferMoneyPageActivity extends AppCompatActivity  {

     UsersClass senderClass;
     UsersClass receiverClass;

    public UsersDataBase usersDataBase;
    private TextView senderName;
    private TextView receverName;
    private TextView senderAccount;
    private TextView receiverAccount;
    private EditText amountToPay;
    private Button payButton;
    private double amountPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money_page);

        senderClass = (UsersClass) getIntent().getSerializableExtra(SendToActivity.SENDER_OBJECT_KEY);
        receiverClass = (UsersClass) getIntent().getSerializableExtra(SendToActivity.TRANSFER_TO_OBJECT_KEY);

        usersDataBase = new UsersDataBase(TransferMoneyPageActivity.this);

        senderName = (TextView) findViewById(R.id.txtSenderName);
        senderAccount = (TextView) findViewById(R.id.txtSenderAccount);
        receverName = (TextView) findViewById(R.id.txtReceiverName);
        receiverAccount = (TextView) findViewById(R.id.txtReceiverAccount);
        payButton = (Button) findViewById(R.id.btnPay);
        amountToPay = (EditText) findViewById(R.id.edtAmountToPay);


        senderName.setText(senderClass.getUserName());
        senderAccount.setText(senderClass.getUserAccount());
        receverName.setText(receiverClass.getUserName());
        receiverAccount.setText(receiverClass.getUserAccount());


        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountPay = amountToPay.getText().toString();
                try {
                    amountPaid =  (double) Double.parseDouble(amountPay);


                }catch (Exception e) {
                    e.printStackTrace();
                }
                double check = 1.00;
                double senderBal =(double) senderClass.getUserBalance();
                double senBal = senderClass.getUserBalance() - amountPaid;
                double recBal = receiverClass.getUserBalance() + amountPaid;
                if(amountPaid <= senderBal && amountPaid>= check) {
                    usersDataBase.modifyUserDatabase(senderClass.getUserAccount(),receiverClass.getUserAccount(),senBal,recBal);
                    TransactionDatabase transactionDatabase = new TransactionDatabase(TransferMoneyPageActivity.this);
                    transactionDatabase.addUserToDatabase(senderClass.getUserName(), receiverClass.getUserName(), amountPaid+"","Success");

                    Toast toast = Toast.makeText(TransferMoneyPageActivity.this, "Payment Successful!!", Toast.LENGTH_SHORT);
                    toast.show();

                    finish();
                }
                else if (amountPaid>senderBal){
                    Toast.makeText(TransferMoneyPageActivity.this, "You don't have enough balance!", Toast.LENGTH_SHORT).show();
                }
                else if (amountPaid == 0) {
                    Toast.makeText(TransferMoneyPageActivity.this, "Please enter the amount first!", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


}