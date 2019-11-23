package com.example.yultravel.Plans;


import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.yultravel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends DialogFragment {
    public PlanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_plan, container, false);
        Button btn = (Button) v.findViewById(R.id.buttonAddPlanFrag);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Added Plan", Toast.LENGTH_SHORT).show();
            }
        });
        Button btnCancel = v.findViewById(R.id.buttonCancelPlan);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dismiss();
            }
        });

        return v;
    }
}
