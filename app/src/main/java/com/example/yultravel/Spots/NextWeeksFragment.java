package com.example.yultravel.Spots;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yultravel.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextWeeksFragment extends Fragment {
    RecyclerView nextWeekRecyclerView;

    public NextWeeksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_next_weeks, container, false);
        ArrayList<Spot> a = new ArrayList<>();
        a.add(new Spot("Loading", "", "", "",null));
        nextWeekRecyclerView = v.findViewById(R.id.RecyclerViewNextWeeksSpots);
        SpotsAdapter spotsAdapter = new SpotsAdapter(getContext(), a);
        nextWeekRecyclerView.setAdapter(spotsAdapter);
        nextWeekRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SpotsEventfulAPI sAPI = new SpotsEventfulAPI(getContext());
        sAPI.getResponseFromEventfulAPI(
                nextWeekRecyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_NEXT_WEEK, 5, 0);
        sAPI.getResponseFromEventfulAPI(
                nextWeekRecyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_NEXT_WEEK, 5, 0);


        return v;
    }

}
