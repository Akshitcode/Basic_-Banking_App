package com.example.basicbankingapp.RecyclerForUser;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.R;

public class AllUserViewHolder extends RecyclerView.ViewHolder {

    private TextView txtForUsername;
    private TextView txtForUserBalance;

    public AllUserViewHolder(@NonNull View itemView) {
        super(itemView);
        txtForUsername = itemView.findViewById(R.id.txtUserName);
        txtForUserBalance = itemView.findViewById(R.id.txtUserBalance);
    }

    public TextView getTxtForUsername() {
        return txtForUsername;
    }

    public TextView getTxtForUserBalance() {
        return txtForUserBalance;
    }
}
