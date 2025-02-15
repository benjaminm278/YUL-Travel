package com.example.yultravel.Spots;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SpotsEventfulAPI {
    private static final String EVENTFUL_BASE_URL = "https://api.eventful.com/json/events/search?";
    private static final String EVENTFUL_APP_KEY_ARG = "app_key";
    private static final String EVENTFUL_LOCATION_ARG = "location";
    private static final String EVENTFUL_DATE_RANGE_ARG = "date";
    private static final String EVENTFUL_PAGE_SIZE_ARG = "page_size";

    private static final String EVENTFUL_APP_KEY = "c9MrGMzV2PkXWdVk";
    private static final String EVENTFUL_LOCATION = "Montreal";

    public static final String EVENTFUL_DATE_RANGE_TODAY = "Today";
    public static final String EVENTFUL_DATE_RANGE_THIS_WEEK = "This Week";
    public static final String EVENTFUL_DATE_RANGE_NEXT_WEEK = "Next Week";

    private Context ctx;

    public SpotsEventfulAPI(Context ctx) {
        this.ctx = ctx;
    }

    public void getResponseFromEventfulAPI(final RecyclerView r, final String dateRange,
                                           int pageSize, final int cardId) {
        try {
            final RequestQueue queue = Volley.newRequestQueue(ctx);

            // Build URI and issue query
            Uri builtURI = Uri.parse(EVENTFUL_BASE_URL).buildUpon()
                    .appendQueryParameter(EVENTFUL_APP_KEY_ARG, EVENTFUL_APP_KEY)
                    .appendQueryParameter(EVENTFUL_LOCATION_ARG, EVENTFUL_LOCATION)
                    .appendQueryParameter(EVENTFUL_DATE_RANGE_ARG, dateRange)
                    .appendQueryParameter(EVENTFUL_PAGE_SIZE_ARG, Integer.toString(pageSize))
                    .build();

            // URI to URL
            String url = builtURI.toString();
            Log.d("bangbang", url);

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    interpretJSONData(response, r, dateRange, cardId);
                    queue.stop();
                }
            },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("bangbang", "OOPS - json");
                        queue.stop();
                    }
                });
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                    DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            queue.add(jsonObjReq);
        }
        catch (Exception e) {
        }
    }

    /**
     *
     * @param response
     */
    private void interpretJSONData(JSONObject response, RecyclerView r, String dateRange,
                                   int cardId) {
        try {
            JSONObject eventsJSON = response.getJSONObject("events");
            JSONArray eventsArr = eventsJSON.getJSONArray("event");

            ArrayList<Spot> spotArrayList = new ArrayList<>();

            // Iterate through each event
            for (int i = 0; i < eventsArr.length(); i++) {
                JSONObject listOfEvents = (JSONObject) eventsArr.get(i);
                String eventTitle = listOfEvents.getString("title");
                String eventDesc = listOfEvents.getString("description");
                String url = listOfEvents.getString("url");
                String address = listOfEvents.getString("venue_address");
                JSONObject imgObj = listOfEvents.getJSONObject("image");
                JSONObject imgObjMed = imgObj.getJSONObject("medium");
                String imgUrl = "http:" + imgObjMed.getString("url");
                Log.d("IMG", imgUrl);

                spotArrayList.add(new Spot(eventTitle, eventDesc, url, address,imgUrl));
            }

            switch (cardId) {
                case 0:
                    SpotsAdapter adapter = new SpotsAdapter(ctx, spotArrayList);
                    r.setAdapter(adapter);
                    break;
                case 1:
                    SpotsListAdapter adapter2 = new SpotsListAdapter(ctx, spotArrayList);
                    r.setAdapter(adapter2);
                    break;
            }
        }
        catch (Exception e) {
        }
    }
}
