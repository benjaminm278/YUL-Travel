package com.example.yultravel.Weather;


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
import com.example.yultravel.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentWeatherFragment extends Fragment {
    private static final String LOCATION_ID = "id";
    private static final String TAG_API_KEY = "APPID";
    private static final String URL_CURRENT_WEATHER="http://api.openweathermap.org/data/2.5/weather?";

    RecyclerView currentRecyclerView;


    public CurrentWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_current_weather, container, false);
        getCurrentWeather(URL_CURRENT_WEATHER);
        currentRecyclerView = v.findViewById(R.id.recyclerviewCurrentWeather);
        currentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        currentRecyclerView.setHasFixedSize(true);

        return v;
    }

    public void getCurrentWeather(String r){
        try {

            final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
            currentWeatherArrayList.add(new CurrentWeather(description,String.valueOf(Math.round(newTemp))+"\u2103",imageUri));
            CurrentWeatherAdapter adapter = new CurrentWeatherAdapter(getContext(),currentWeatherArrayList);
            currentRecyclerView.setAdapter(adapter);

        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
