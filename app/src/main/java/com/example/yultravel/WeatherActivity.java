package com.example.yultravel;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    private static final String URL ="http://api.openweathermap.org/data/2.5/forecast?";
    private static final String LOCATION_ID="id";
    private static final String TAG_API_KEY ="APPID";
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getWeatherResponse(URL);
        textView =findViewById(R.id.textView10);


    }
    public void getWeatherResponse(String r){
        try{
            final RequestQueue requestQueue = Volley.newRequestQueue(this);
            Uri builtUri = Uri.parse(URL).buildUpon()
                    .appendQueryParameter(LOCATION_ID,"6077243")
                    .appendQueryParameter(TAG_API_KEY,"0bd2041bf9a7f470a0c35b4bd399864a").build();
            String url = builtUri.toString();
            Log.d("URL", url);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url
                    , null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    interpretJSON();
                 Log.d("HELLOMAN",response.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("","hello");
                }
            });
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e){

        }
    }

    private void interpretJSON() {
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray listArray = jsonObject.getJSONArray("list");
            for(int i=0; i<listArray.length(); i++){
                JSONObject list = listArray.getJSONObject(i);
                JSONObject dt = list.getJSONObject("dt");
                JSONObject main = dt.getJSONObject("main");




            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
