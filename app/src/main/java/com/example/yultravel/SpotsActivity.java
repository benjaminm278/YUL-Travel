package com.example.yultravel;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yultravel.Plans.Plan;
import com.example.yultravel.Plans.PlanAdapter;

import org.json.JSONObject;

import java.util.ArrayList;

public class SpotsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Spot> spotArrayList;
    TextView title;

    private static final String EVENTFUL_BASE_URL = "https://api.eventful.com/json/events/search?";
    private static final String EVENTFUL_APP_KEY_ARG = "app_key";
    private static final String EVENTFUL_LOCATION_ARG = "location";

    private static final String EVENTFUL_APP_KEY = "c9MrGMzV2PkXWdVk";
    private static final String EVENTFUL_LOCATION = "Montreal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        /*
        recyclerView = findViewById(R.id.recyclerviewSpots);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();*/

        // Volley code
        final TextView t = (TextView) findViewById(R.id.textView26);

        try {
            final RequestQueue queue = Volley.newRequestQueue(this);

            // Build URI and issue query
            Uri builtURI = Uri.parse(EVENTFUL_BASE_URL).buildUpon()
                    .appendQueryParameter(EVENTFUL_APP_KEY_ARG, EVENTFUL_APP_KEY)
                    .appendQueryParameter(EVENTFUL_LOCATION_ARG, EVENTFUL_LOCATION)
                    .build();

            // URI to URL
            String url = builtURI.toString();
            Log.d("bangbang", url);

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("bangbang", "Response: " + response.toString());
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

            StringRequest sr = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("bangbang", "response stored" + response);
                            //interpretJSONData(response);
                            queue.stop();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("bangbang", "OOPS");
                            queue.stop();
                        }
                    });

            queue.add(sr);
        }
        catch (Exception e) {

        }
    }
    private void initializeData() {
        spotArrayList = new ArrayList<>();
        spotArrayList.add(new Spot("Olympic Stadium"));
        spotArrayList.add(new Spot("Old Port"));

    }
    private void initializeAdapter() {
        SpotsAdapter adapter = new SpotsAdapter(this, spotArrayList);
        recyclerView.setAdapter(adapter);
    }
}
