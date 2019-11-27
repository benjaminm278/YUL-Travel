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
public class ThisWeeksFragment extends Fragment {
    RecyclerView thisWeekRecyclerView;

    public ThisWeeksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_this_weeks, container, false);
        ArrayList<Spot> a = new ArrayList<>();
        a.add(new Spot("Loading", "", "", "",null));

        thisWeekRecyclerView = v.findViewById(R.id.RecyclerViewThisWeeksSpots);
        SpotsAdapter spotsAdapter = new SpotsAdapter(getContext(), a);
        thisWeekRecyclerView.setAdapter(spotsAdapter);
        thisWeekRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SpotsEventfulAPI sAPI = new SpotsEventfulAPI(getContext());
        sAPI.getResponseFromEventfulAPI(
                thisWeekRecyclerView, SpotsEventfulAPI.EVENTFUL_DATE_RANGE_THIS_WEEK, 5, 0);


        return v;
    }

}
