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

    public static final String DATE_RANGE_EXTRA = "com.example.yultravel.Spots.dateRange.EXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        //androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.spottoolbar);
        //setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.spotTab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Today's Hot Spots"));
        tabLayout.addTab(tabLayout.newTab().setText("This Week"));
        tabLayout.addTab(tabLayout.newTab().setText("Next Week"));

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

    public void openMoreHotSpots(View view) {
        Intent moreHotSpotsActivity = new Intent(this, MoreSpotsActivity.class);

        // Switch case used to pass data to intent to display different results
        switch (view.getId()) {
            case R.id.viewMoreOfTodaysHotSpots:
                moreHotSpotsActivity.putExtra(DATE_RANGE_EXTRA, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_TODAY);
                break;
            case R.id.viewMoreOfThisWeekHotSpotsTextView:
                moreHotSpotsActivity.putExtra(DATE_RANGE_EXTRA, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_THIS_WEEK);
                break;
            case R.id.viewMoreOfNextWeeksHotSpotsTextView:
                moreHotSpotsActivity.putExtra(DATE_RANGE_EXTRA, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_NEXT_WEEK);
                break;
        }

        startActivity(moreHotSpotsActivity);
    }
}
