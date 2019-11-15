package com.example.yultravel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Plans.Plan;
import com.example.yultravel.Plans.PlanAdapter;

import java.util.ArrayList;

public class SpotsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Spot> spotArrayList;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);
        recyclerView = findViewById(R.id.recyclerviewSpots);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
    }
    private void initializeData() {
        spotArrayList = new ArrayList<>();
        spotArrayList.add(new Spot("Olympic Stadium"));
        spotArrayList.add(new Spot("Old Port"));

    }
    private void initializeAdapter() {
        SpotsAdapter adapter = new SpotsAdapter(this, spotArrayList);
        recyclerView.setAdapter(adapter);
    }
}
