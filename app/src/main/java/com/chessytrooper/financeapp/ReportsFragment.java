package com.chessytrooper.financeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ReportsFragment extends Fragment {

    TextView income;
    public ReportsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        GraphFragment graphFragment = new GraphFragment();
        childFragTrans.add(R.id.graph_container, graphFragment);
        childFragTrans.addToBackStack("B");
        childFragTrans.commit();
        View view = inflater.inflate(R.layout.fragment_reports, container, false);
        income = view.findViewById(R.id.textView7);
        return view;
    }

    public void change(String txt){
        income.setText(txt);
    }
}