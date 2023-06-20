package com.example.basicbankingapp.RecyclerForTransactionHistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewTreeViewModelKt;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.ModelForTransactionDatabase.TransactionClass;
import com.example.basicbankingapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionHistoryViewHolder> {

    private ArrayList<TransactionClass> transactionClasses;

    public TransactionAdapter(ArrayList<TransactionClass> transactionClasses){
        this.transactionClasses = transactionClasses;
    }
    @NonNull
    @Override
    public TransactionHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.transaction_history_view_holder,parent,false);
        return new TransactionHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHistoryViewHolder holder, int position) {
        holder.getTxtSenderName().setText(transactionClasses.get(position).getSenderName());
        holder.getTxtReceiverName().setText(transactionClasses.get(position).getReceiverName());
        String formattedTransAmount = NumberFormat.getCurrencyInstance().format(transactionClasses.get(position).getTransferedAmount());
        holder.getTxtTransferedAmount().setText(formattedTransAmount);
        holder.getTxtPaySuccess().setText(transactionClasses.get(position).getPayStatus());
    }

    @Override
    public int getItemCount() {
        return transactionClasses.size();
    }
}
