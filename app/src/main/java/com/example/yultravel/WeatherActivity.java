package com.example.yultravel;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.yultravel.Plans.Plan;
import com.example.yultravel.Plans.PlanAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?";
    private static final String LOCATION_ID = "id";
    private static final String TAG_API_KEY = "APPID";
    RecyclerView recyclerView;
    ArrayList<Weather> weatherArrayList;
    WeatherAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getWeatherResponse(URL);
        recyclerView = findViewById(R.id.weatherRecyclerView);

    }

    public void getWeatherResponse(String r) {
        try {
            final RequestQueue requestQueue = Volley.newRequestQueue(this);
            Uri builtUri = Uri.parse(URL).buildUpon()
                    .appendQueryParameter(LOCATION_ID, "6077243")
                    .appendQueryParameter(TAG_API_KEY, "0bd2041bf9a7f470a0c35b4bd399864a").build();
            String url = builtUri.toString();
            Log.d("URL", url);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url
                    , null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    interpretJSON(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("", "hello");
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {

        }
    }

    private void interpretJSON(JSONObject response) {
        try {
            JSONArray listArray = response.getJSONArray("list");

            Log.d("bangbang", listArray.getJSONObject(0) + " :)");

            for (int i = 0; i < listArray.length(); i++) {
                JSONObject list = listArray.getJSONObject(i);

                JSONObject main = list.getJSONObject("main");
                double temp = main.getDouble("temp");
                Log.d("Temp", String.valueOf(temp));
                JSONArray weatherArray = list.getJSONArray("weather");
                JSONObject weathers = weatherArray.getJSONObject(0);
                String mains = weathers.getString("main");
                String date = list.getString("dt_txt");
                Log.d("yaya", date);

                weatherArrayList.add(new Weather(String.valueOf(temp),date));
            }
           adapter= new WeatherAdapter(this, weatherArrayList);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
