package com.example.basicbankingapp.ModelForUserDataBase;

import java.io.Serializable;

public class UsersClass implements Serializable {

    private String userName;
    private String userAccount;
    private String userPhoneNumber;
    private double userBalance;

    public UsersClass(String userName, String userAccount, String userPhoneNumber, double userBalance) {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPhoneNumber = userPhoneNumber;
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }
}
