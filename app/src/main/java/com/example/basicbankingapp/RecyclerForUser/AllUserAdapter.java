package com.example.basicbankingapp.RecyclerForUser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;
import com.example.basicbankingapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class AllUserAdapter extends RecyclerView.Adapter<AllUserViewHolder> {

    private ArrayList<UsersClass> usersClasses;

    public interface UserIsClickedInterface {
        void userIsClicked(UsersClass usersClass);
    }

    private UserIsClickedInterface userIsClickedInterface;
    public AllUserAdapter(ArrayList<UsersClass> usersClasses, UserIsClickedInterface userIsClickedInterface) {
        this.usersClasses=usersClasses;
        this.userIsClickedInterface = userIsClickedInterface;

    }

    @NonNull
    @Override
    public AllUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.all_users_view_holder,parent,false);
        return new AllUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllUserViewHolder holder,final int position) {
        holder.getTxtForUsername().setText(usersClasses.get(position).getUserName());

        String balanceFormatted = NumberFormat.getCurrencyInstance().format(usersClasses.get(position).getUserBalance());
        holder.getTxtForUserBalance().setText(balanceFormatted);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userIsClickedInterface.userIsClicked(usersClasses.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersClasses.size();
    }
}
