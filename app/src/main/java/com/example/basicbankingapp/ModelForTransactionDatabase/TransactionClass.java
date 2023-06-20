package com.example.basicbankingapp.ModelForTransactionDatabase;

import java.io.Serializable;

public class TransactionClass implements Serializable {

    private String senderName;
    private String receiverName;
    private double transferedAmount;
    private String payStatus;

    public TransactionClass(String senderName, String receiverName, double transferedAmount, String payStatus) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.transferedAmount = transferedAmount;
        this.payStatus = payStatus;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getTransferedAmount() {
        return transferedAmount;
    }

    public void setTransferedAmount(double transferedAmount) {
        this.transferedAmount = transferedAmount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}

