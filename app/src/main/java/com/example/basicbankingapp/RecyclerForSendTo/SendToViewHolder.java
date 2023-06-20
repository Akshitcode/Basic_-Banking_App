package com.example.basicbankingapp.RecyclerForSendTo;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.R;

public class SendToViewHolder extends RecyclerView.ViewHolder {

    private TextView txtSendToUserName;

    public SendToViewHolder(View view) {
        super(view);
        txtSendToUserName = view.findViewById(R.id.txtSendToUserName);
    }

    public TextView getTxtSendToUserName() {
        return txtSendToUserName;
    }
}
