package com.example.yultravel.Spots;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yultravel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodaysHotSpotFragment extends Fragment {


    public TodaysHotSpotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todays_hot_spot, container, false);
    }

}
