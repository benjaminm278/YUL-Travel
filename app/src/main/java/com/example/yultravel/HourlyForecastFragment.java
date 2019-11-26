package com.example.yultravel;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyForecastFragment extends Fragment {

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?";
    private static final String LOCATION_ID = "id";
    private static final String TAG_API_KEY = "APPID";
    RecyclerView recyclerView;


    public HourlyForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_hourly_forecast, container, false);
        getWeatherResponse(URL);
        recyclerView = v.findViewById(R.id.weatherRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);


        return v;
    }
    public void getWeatherResponse(String r) {
        try {

            final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                    Log.d("", "hi");
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {

        }
    }
        private void interpretJSON(JSONObject response) {
            try {
                ArrayList<Weather> weatherArrayList = new ArrayList<>();
                JSONArray listArray = response.getJSONArray("list");

                Log.d("bangbang", listArray.getJSONObject(0) + " :)");

                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject list = listArray.getJSONObject(i);

                    JSONObject main = list.getJSONObject("main");
                    double temp = main.getDouble("temp");
                    double newTemp = temp - 273.15;
                    Log.d("Temp", String.valueOf(newTemp));
                    JSONArray weatherArray = list.getJSONArray("weather");
                    JSONObject weathers = weatherArray.getJSONObject(0);
                    String mains = weathers.getString("main");
                    String icon = weathers.getString("icon");
                    String date = list.getString("dt_txt");
                    String imageUri = "http://openweathermap.org/img/wn/" + icon + ".png";

                    Log.d("yaya", date);
                    Log.d("icon", imageUri);

                    weatherArrayList.add(new Weather(String.valueOf(Math.round(newTemp))+" \u2103", date, imageUri));

                }
                WeatherAdapter adapter = new WeatherAdapter(getContext(), weatherArrayList);
                recyclerView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}
