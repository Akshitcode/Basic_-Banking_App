package com.example.basicbankingapp.RecyclerForTransactionHistory;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.R;

public class TransactionHistoryViewHolder extends RecyclerView.ViewHolder {

    private TextView txtSenderName;
    private TextView txtReceiverName;
    private TextView txtTransferedAmount;
    private TextView txtPaySuccess;


    public TransactionHistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        txtSenderName = itemView.findViewById(R.id.txtHistorySenderName);
        txtReceiverName = itemView.findViewById(R.id.txtHistoryReceiverName);
        txtTransferedAmount = itemView.findViewById(R.id.txtHistoryTransAmount);
        txtPaySuccess = itemView.findViewById(R.id.txtHistoryPaySuccess);
    }

    public TextView getTxtSenderName() {
        return txtSenderName;
    }

    public TextView getTxtReceiverName() {
        return txtReceiverName;
    }

    public TextView getTxtTransferedAmount() {
        return txtTransferedAmount;
    }

    public TextView getTxtPaySuccess() {
        return txtPaySuccess;
    }
}
