package com.chessytrooper.financeapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        BottomNavigationView btnView = findViewById(R.id.bottomNavigationView);
        btnView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            int itemId = item.getItemId(); // get the constant ID value

            if (itemId == R.id.item1) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.item2) {
                selectedFragment = new ReportsFragment();
            } else if (itemId == R.id.item3) {
                selectedFragment = new CardsFragment();
            } else if (itemId == R.id.item4) {
                selectedFragment = new ProfileFragment();
            }

            // Begin transaction
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, selectedFragment)
                    .commit();

            return true;
        }
    };
}