package com.example.yultravel.Spots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.yultravel.R;
import com.example.yultravel.Weather.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SpotsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.spottoolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.spotTab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Today's Hot Spots"));
        tabLayout.addTab(tabLayout.newTab().setText("This Week"));
        tabLayout.addTab(tabLayout.newTab().setText("Next Week"));
        tabLayout.addTab(tabLayout.newTab().setText("All Time"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.spotpager);
        final SpotsPagerAdapter adapter = new SpotsPagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }

}
