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

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewholder> {

    private ArrayList<PopularDomain> popularDomains;

    public PopularAdapter(ArrayList<PopularDomain> popularDomains) {
        this.popularDomains = popularDomains;
    }

    @NonNull
    @Override
    public PopularViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_views, parent, false);
        return new PopularViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewholder holder, int position) {
        holder.popularName.setText(popularDomains.get(position).getTitle());
        holder.popularPic.setImageResource(popularDomains.get(position).getPic());

    }

    @Override
    public int getItemCount() {
        return popularDomains.size();
    }

    public class PopularViewholder extends RecyclerView.ViewHolder {

        public TextView popularName;
        public ImageView popularPic;

        public PopularViewholder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.popularName);
            popularPic = itemView.findViewById(R.id.popularPic);
        }
    }
}
