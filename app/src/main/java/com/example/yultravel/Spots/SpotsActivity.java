package com.example.yultravel.Spots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    private ArrayList<Spot> spotArrayList;
    private TextView title;
    public static String eventfulResponseStr;

    private static final String EVENTFUL_BASE_URL = "https://api.eventful.com/json/events/search?";
    private static final String EVENTFUL_APP_KEY_ARG = "app_key";
    private static final String EVENTFUL_LOCATION_ARG = "location";
    private static final String EVENTFUL_DATE_RANGE_ARG = "date";
    private static final String EVENTFUL_PAGE_SIZE_ARG = "page_size";

    private static final String EVENTFUL_APP_KEY = "c9MrGMzV2PkXWdVk";
    private static final String EVENTFUL_LOCATION = "Montreal";
    private static final String EVENTFUL_DATE_RANGE_TODAY = "Today";
    private static final String EVENTFUL_DATE_RANGE_THIS_WEEK = "This Week";
    private static final String EVENTFUL_DATE_RANGE_NEXT_WEEK = "Next Week";
    private static final String EVENTFUL_PAGE_SIZE = "5";

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
                moreHotSpotsActivity.putExtra(DATE_RANGE_EXTRA, EVENTFUL_DATE_RANGE_TODAY);
                break;
            case R.id.viewMoreOfThisWeekHotSpotsTextView:
                moreHotSpotsActivity.putExtra(DATE_RANGE_EXTRA, EVENTFUL_DATE_RANGE_THIS_WEEK);
                break;
            case R.id.viewMoreOfNextWeeksHotSpotsTextView:
                moreHotSpotsActivity.putExtra(DATE_RANGE_EXTRA, EVENTFUL_DATE_RANGE_NEXT_WEEK);
                break;
        }

        startActivity(moreHotSpotsActivity);
    }
}
