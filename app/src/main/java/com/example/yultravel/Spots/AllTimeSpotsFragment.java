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
public class AllTimeSpotsFragment extends Fragment {


    public AllTimeSpotsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_time_spots, container, false);
    }

}
