package com.example.yultravel.Spots;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yultravel.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodaysHotSpotFragment extends Fragment {
    RecyclerView recyclerView;
    public static final String DATE_RANGE_EXTRA = "com.example.yultravel.Spots.dateRange.EXTRA";
    public TodaysHotSpotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_todays_hot_spot, container, false);
        ArrayList<Spot> a = new ArrayList<>();
        a.add(new Spot("Loading", "", "", "",null));
        recyclerView = v.findViewById(R.id.RecyclerViewSpots);
        SpotsAdapter spotsAdapter = new SpotsAdapter(getContext(), a);
        recyclerView.setAdapter(spotsAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        SpotsEventfulAPI sAPI = new SpotsEventfulAPI(getContext());
        sAPI.getResponseFromEventfulAPI(
                recyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_TODAY, 5, 0);

        return v;


    }


}




