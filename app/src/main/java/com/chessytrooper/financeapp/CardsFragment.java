package com.chessytrooper.financeapp;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CardsFragment extends Fragment {
    private RecyclerView.Adapter adapter, adapter2, adapter3;
    private RecyclerView cardList, popularList, transactionList;
    List<Atm> atmList = new ArrayList<>();
    AtmAdapter atmAdapter;


    public CardsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cards, container, false);

        InsertData(view);
        recyclerViewPopular(view);
        recyclerViewTransaction(view);
        return view;
    }

    private void recyclerViewTransaction(View view) {
        transactionList = view.findViewById(R.id.transactions_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        transactionList.setLayoutManager(layoutManager);

        ArrayList<TransactionDomain> transactionDomains = new ArrayList<>();
        transactionDomains.add(new TransactionDomain("logo", "Traveloka", "20 March, 09:00 AM", "120.00"));
        transactionDomains.add(new TransactionDomain("mask", "Starbucks", "20 March, 09:00 AM", "80.99"));
        adapter2 = new TransactionAdapter(transactionDomains);
        transactionList.setAdapter(adapter2);

    }

    private void recyclerViewPopular(View view) {
        popularList = view.findViewById(R.id.popular_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        popularList.setLayoutManager(layoutManager);

        ArrayList<PopularDomain> popularDomains = new ArrayList<PopularDomain>();
        popularDomains.add(new PopularDomain("All", R.drawable.vector));
        popularDomains.add(new PopularDomain("Health", R.drawable.vector_1));
        popularDomains.add(new PopularDomain("Travel", R.drawable.vector_2));
        popularDomains.add(new PopularDomain("Food", R.drawable.vector_3));

        adapter = new PopularAdapter(popularDomains);
        popularList.setAdapter(adapter);

    }

    private void InsertData(View view) {
        cardList = view.findViewById(R.id.card_recyclerView);
        atmAdapter = new AtmAdapter(atmList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        cardList.setLayoutManager(layoutManager);
        cardList.setItemAnimator(new DefaultItemAnimator());
        cardList.setAdapter(atmAdapter);
        Atm atm = new Atm("123456789", "VISA", 2350);
        atmList.add(atm);
        atm = new Atm("987762134", "MASTER VISA", 7310);
        atmList.add(atm);
        atm = new Atm("948759438", "MASTER CARD", 8567);
        atmList.add(atm);
        atm = new Atm("94989438", "VISA MASTER", 9087);
        atmList.add(atm);

        atmAdapter.notifyDataSetChanged();
    }


}