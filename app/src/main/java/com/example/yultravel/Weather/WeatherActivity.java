package com.example.yultravel.Weather;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

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

public class WeatherActivity extends AppCompatActivity {

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?";
    private static final String LOCATION_ID = "id";
    private static final String TAG_API_KEY = "APPID";
    private static final String URL_CURRENT_WEATHER="http://api.openweathermap.org/data/2.5/weather?";
    RecyclerView recyclerView;
    RecyclerView currentRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getWeatherResponse(URL);
        recyclerView = findViewById(R.id.weatherRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        getCurrentWeather(URL_CURRENT_WEATHER);
        currentRecyclerView = findViewById(R.id.recyclerviewCurrentWeather);
        currentRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        currentRecyclerView.setHasFixedSize(true);


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
                    Log.d("", "hi");
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {

        }
    }
    public void getCurrentWeather(String r){
        try {

            final RequestQueue requestQueue = Volley.newRequestQueue(this);
            Uri builtUri = Uri.parse(URL_CURRENT_WEATHER).buildUpon()
                    .appendQueryParameter("q", "Montreal,CA")
                    .appendQueryParameter(TAG_API_KEY, "5fb88351043c886d812bb2b58fdfbe21").build();
            String url = builtUri.toString();
            Log.d("URL", url);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url
                    , null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    interpretJSONCurrentWeather(response);
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
            WeatherAdapter adapter = new WeatherAdapter(this, weatherArrayList);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void interpretJSONCurrentWeather(JSONObject response){
        try {
            ArrayList<CurrentWeather> currentWeatherArrayList = new ArrayList<>();
            JSONArray weatherArray = response.getJSONArray("weather");
            JSONObject main = weatherArray.getJSONObject(0);
            String weather = main.getString("main");
            String description = main.getString("description");
            Log.d("DADDY",weather);
            Log.d("MOMMY",description);
            String icon = main.getString("icon");
            String imageUri = "http://openweathermap.org/img/wn/" + icon + ".png";
            Log.d("HA",icon);
           JSONObject object = response.getJSONObject("main");
           double temp = object.getDouble("temp");
           double newTemp =temp-273.15;
           Math.round(newTemp);
           Log.d("FASA",String.valueOf(temp));
           currentWeatherArrayList.add(new CurrentWeather(description,String.valueOf(Math.round(newTemp))+" \u2103",imageUri,weather));
           CurrentWeatherAdapter adapter = new CurrentWeatherAdapter(this,currentWeatherArrayList);
           currentRecyclerView.setAdapter(adapter);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
