package com.chessytrooper.financeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private ArrayList<TransactionDomain> transactionDomains;

    public TransactionAdapter(ArrayList<TransactionDomain> transactionDomains) {
        this.transactionDomains = transactionDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.transactions_views, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(transactionDomains.get(position).getTitle());
        holder.date.setText(transactionDomains.get(position).getDate());
        holder.bill.setText(transactionDomains.get(position).getBill());

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(transactionDomains.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .override(70,70)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return transactionDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView pic;
        public TextView title, date, bill;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pic = itemView.findViewById(R.id.transaction_pic);
            title = itemView.findViewById(R.id.transaction_title);
            date = itemView.findViewById(R.id.transaction_date);
            bill = itemView.findViewById(R.id.transaction_bill);
        }
    }
}
