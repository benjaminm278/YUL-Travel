package com.example.yultravel.Spots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;
import com.example.yultravel.SpotsEventfulAPI;

import java.util.ArrayList;

public class SpotsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView thisWeekRecyclerView;
    private RecyclerView nextWeekRecyclerView;

    public static final String DATE_RANGE_EXTRA = "com.example.yultravel.Spots.dateRange.EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        ArrayList<Spot> a = new ArrayList<>();
        a.add(new Spot("Loading", ""));

        recyclerView = findViewById(R.id.RecyclerViewSpots);
        SpotsAdapter spotsAdapter = new SpotsAdapter(this, a);
        recyclerView.setAdapter(spotsAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(llm);

        thisWeekRecyclerView = findViewById(R.id.RecyclerViewThisWeeksSpots);
        thisWeekRecyclerView.setAdapter(spotsAdapter);
        thisWeekRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        nextWeekRecyclerView = findViewById(R.id.RecyclerViewNextWeeksSpots);
        nextWeekRecyclerView.setAdapter(spotsAdapter);
        nextWeekRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        SpotsEventfulAPI sAPI = new SpotsEventfulAPI(this);
        sAPI.getResponseFromEventfulAPI(recyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_TODAY, 5);
        sAPI.getResponseFromEventfulAPI(thisWeekRecyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_THIS_WEEK, 5);
        sAPI.getResponseFromEventfulAPI(nextWeekRecyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_NEXT_WEEK, 5);
    }

    /**
     * Opens a new activity containing a list of all events
     * @param view
     */
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
