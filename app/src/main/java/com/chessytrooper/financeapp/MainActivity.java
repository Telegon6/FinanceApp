package com.chessytrooper.financeapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    private float opaque = 0.5F;
    private float noOpaque = 1;

    private ImageView dot0, dot1, dot2;

    LinearLayout.LayoutParams bigLp = new LinearLayout.LayoutParams(16,16);
    LinearLayout.LayoutParams smallLp = new LinearLayout.LayoutParams(10,10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dot0 = findViewById(R.id.dot0);
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);

        bigLp.setMargins(10,10,10,10);
        smallLp.setMargins(10,10,10,10);

        dot0.setAlpha(noOpaque);
        dot1.setAlpha(opaque);
        dot2.setAlpha(opaque);
        dot0.setLayoutParams(bigLp);
        dot1.setLayoutParams(smallLp);
        dot2.setLayoutParams(smallLp);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                changeColor();
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                changeColor();
            }
        });

    }

    private void changeColor() {

        bigLp.setMargins(10,10,10,10);
        smallLp.setMargins(10,10,10,10);

        switch (viewPager.getCurrentItem()){
            case 0:
                dot0.setAlpha(noOpaque);
                dot1.setAlpha(opaque);
                dot2.setAlpha(opaque);
                dot0.setLayoutParams(bigLp);
                dot1.setLayoutParams(smallLp);
                dot2.setLayoutParams(smallLp);
                break;
            case 1:
                dot0.setAlpha(opaque);
                dot1.setAlpha(noOpaque);
                dot2.setAlpha(opaque);
                dot0.setLayoutParams(smallLp);
                dot1.setLayoutParams(bigLp);
                dot2.setLayoutParams(smallLp);
                break;
            case 2:
                dot0.setAlpha(opaque);
                dot1.setAlpha(opaque);
                dot2.setAlpha(noOpaque);
                dot0.setLayoutParams(smallLp);
                dot1.setLayoutParams(smallLp);
                dot2.setLayoutParams(bigLp);
                break;
        }
    }

    public void onReports(View v){
        Intent intent = new Intent(this, ReportsActivity.class);
        startActivity(intent);
    }
}