package com.example.yultravel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlansActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Plan> planArrayList;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();


    }

    private void initializeData() {
        planArrayList = new ArrayList<>();
        planArrayList.add(new Plan("Hiking"));

    }
    private void initializeAdapter() {
        PlanAdapter adapter = new PlanAdapter(this, planArrayList);
        recyclerView.setAdapter(adapter);
    }
}
