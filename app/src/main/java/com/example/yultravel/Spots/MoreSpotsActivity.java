package com.example.yultravel.Spots;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

public class MoreSpotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_spots);

        Intent i = getIntent();
        String a = i.getStringExtra(SpotsActivity.DATE_RANGE_EXTRA);

        TextView dateRange = findViewById(R.id.dateRangeOfEventsTextView);
        dateRange.setText(a);

        callEventfulAPI(a);
    }

    /**
     * Call Eventful API
     */
    private void callEventfulAPI(String dateRange) {
        RecyclerView eventsRecyclerView = findViewById(R.id.listOfEventsRecyclerView);
        SpotsEventfulAPI sAPI = new SpotsEventfulAPI(this);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sAPI.getResponseFromEventfulAPI(eventsRecyclerView, dateRange, 20, 1);
    }
}
