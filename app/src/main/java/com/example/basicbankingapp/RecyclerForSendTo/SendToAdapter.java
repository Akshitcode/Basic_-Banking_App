package com.example.basicbankingapp.RecyclerForSendTo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;
import com.example.basicbankingapp.R;

import java.util.ArrayList;

public class SendToAdapter extends RecyclerView.Adapter<SendToViewHolder> {
    private ArrayList<UsersClass> usersClasses;

    public interface ReceiverIsSelectedInterface {

        void ReceiverIsClicked(UsersClass usersClass);
    }
    private ReceiverIsSelectedInterface receiverIsSelectedInterface;
    public SendToAdapter(ArrayList<UsersClass> usersClasses , ReceiverIsSelectedInterface receiverIsSelectedInterface ) {

        this.usersClasses=usersClasses;
        this.receiverIsSelectedInterface = receiverIsSelectedInterface;
    }

    @NonNull
    @Override
    public SendToViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.send_to_view_holder, parent ,false);
        return new SendToViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SendToViewHolder holder,final int position) {

        holder.getTxtSendToUserName().setText(usersClasses.get(position).getUserName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiverIsSelectedInterface.ReceiverIsClicked(usersClasses.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersClasses.size();
    }
}
