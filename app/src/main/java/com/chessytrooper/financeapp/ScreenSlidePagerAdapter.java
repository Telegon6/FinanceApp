package com.chessytrooper.financeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScreenSlidePagerAdapter extends RecyclerView.Adapter<ScreenSlidePagerAdapter.MyViewHolder> {

    private Context context;

    public ScreenSlidePagerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ScreenSlidePagerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.onboarding, parent, false);

        return new MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull ScreenSlidePagerAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

