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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yultravel.Plans.Plan;
import com.example.yultravel.Plans.PlanAdapter;

import java.util.ArrayList;

public class SpotsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Spot> spotArrayList;
    TextView title;

    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    private static final String QUERY_PARAM = "q";
    private static final String MAX_RESULTS = "maxResults";
    private static final String PRINT_TYPE = "printType";

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
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, "Romeo")
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();

            // URI to URL
            String url = builtURI.toString();
            Log.d("bangbang", url);

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
