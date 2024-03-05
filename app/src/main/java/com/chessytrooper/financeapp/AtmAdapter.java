package com.chessytrooper.financeapp;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AtmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Atm> atmList;

    public AtmAdapter(List<Atm> atmList) {
        this.atmList = atmList;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            return new AddCardViewHolder(inflater.inflate(R.layout.add_card, parent, false));
        } else {
            return new AtmViewHolder(inflater.inflate(R.layout.atm_cards, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof AtmViewHolder) {
            if (position > 0) {
                Atm atm = atmList.get(position - 1); // Subtract 1 to account for AddCardViewHolder

                ((AtmViewHolder) holder).balance.setText("" + atm.getBalance());
                ((AtmViewHolder) holder).accountNo.setText(atm.getAccountNo());
                ((AtmViewHolder) holder).card.setText(atm.getCard());
            }
        }

    }

    @Override
    public int getItemCount() {
        return atmList.size() + 1;
    }

    public class AddCardViewHolder extends RecyclerView.ViewHolder{

        public ImageView addCard;

        public AddCardViewHolder(@NonNull View itemView) {
            super(itemView);

            addCard = itemView.findViewById(R.id.image_add);
        }
    }


    public class AtmViewHolder extends RecyclerView.ViewHolder {

        public TextView accountNo, card, balance;
        public AtmViewHolder(@NonNull View itemView) {
            super(itemView);

            accountNo = itemView.findViewById(R.id.accountNo);
            card = itemView.findViewById(R.id.card);
            balance = itemView.findViewById(R.id.balance);
        }
    }

}
