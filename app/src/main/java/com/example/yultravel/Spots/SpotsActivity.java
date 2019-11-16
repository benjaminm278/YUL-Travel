package com.example.yultravel.Spots;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.yultravel.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SpotsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Spot> spotArrayList;
    TextView title;

    private static final String EVENTFUL_BASE_URL = "https://api.eventful.com/json/events/search?";
    private static final String EVENTFUL_APP_KEY_ARG = "app_key";
    private static final String EVENTFUL_LOCATION_ARG = "location";
    private static final String EVENTFUL_DATE_RANGE_ARG = "date";
    private static final String EVENTFUL_PAGE_SIZE_ARG = "page_size";

    private static final String EVENTFUL_APP_KEY = "c9MrGMzV2PkXWdVk";
    private static final String EVENTFUL_LOCATION = "Montreal";
    private static final String EVENTFUL_DATE_RANGE = "today";
    private static final String EVENTFUL_PAGE_SIZE = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        ArrayList<Spot> a = new ArrayList<>();
        a.add(new Spot("Mont-Royal", ""));
        a.add(new Spot("Hockey night", ""));

        recyclerView = findViewById(R.id.RecyclerViewSpots);
        SpotsAdapter spotsAdapter = new SpotsAdapter(this, a);
        recyclerView.setAdapter(spotsAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(llm);
        //recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();

        // Volley code
        final TextView t = (TextView) findViewById(R.id.titleOfSpot);

        try {
            final RequestQueue queue = Volley.newRequestQueue(this);

            // Build URI and issue query
            Uri builtURI = Uri.parse(EVENTFUL_BASE_URL).buildUpon()
                    .appendQueryParameter(EVENTFUL_APP_KEY_ARG, EVENTFUL_APP_KEY)
                    .appendQueryParameter(EVENTFUL_LOCATION_ARG, EVENTFUL_LOCATION)
                    .appendQueryParameter(EVENTFUL_DATE_RANGE_ARG, EVENTFUL_DATE_RANGE)
                    .appendQueryParameter(EVENTFUL_PAGE_SIZE_ARG, EVENTFUL_PAGE_SIZE)
                    .build();

            // URI to URL
            String url = builtURI.toString();
            Log.d("bangbang", url);

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("bangbang", "Response: " + response.toString());
                            interpretJSONData(response);
                            queue.stop();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("bangbang", "OOPS - json");
                            queue.stop();
                        }
            });

            queue.add(jsonObjReq);
        }
        catch (Exception e) {

        }
    }

    /**
     *
     * @param response
     */
    private void interpretJSONData(JSONObject response) {
        try {
            // Collect event names
            String x = response.getString("total_items");
            Toast.makeText(this, x, Toast.LENGTH_SHORT).show();

            JSONObject eventsJSON = response.getJSONObject("events");
            JSONArray eventsArr = eventsJSON.getJSONArray("event");

            ArrayList<Spot> spotArrayList = new ArrayList<>();

            // Iterate through each event
            for (int i = 0; i < eventsArr.length(); i++) {
                JSONObject listOfEvents = (JSONObject) eventsArr.get(i);
                String eventTitle = listOfEvents.getString("title");
                String eventDesc = listOfEvents.getString("description");
                spotArrayList.add(new Spot(eventTitle, eventDesc));
            }

            SpotsAdapter adapter = new SpotsAdapter(this, spotArrayList);
            recyclerView.setAdapter(adapter);
        }
        catch (Exception e) {

        }
    }

    private void initializeData() {
        /*
        spotArrayList = new ArrayList<>();
        spotArrayList.add(new Spot("Olympic Stadium"));
        spotArrayList.add(new Spot("Old Port"));
        */
    }
    private void initializeAdapter() {/*
        SpotsAdapter adapter = new SpotsAdapter(this, spotArrayList);
        recyclerView.setAdapter(adapter);*/
    }
}
