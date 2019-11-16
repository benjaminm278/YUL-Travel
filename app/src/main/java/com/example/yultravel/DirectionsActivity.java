package com.example.yultravel;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DirectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        // String arraylist
        ArrayList<String> categoryNames = new ArrayList();
        categoryNames.add("Airport");

        // RecyclerView code
        RecyclerView directionsRC = findViewById(R.id.directionsCategoryRecyclerView);
        DirectionsCategoryAdapter adapter = new DirectionsCategoryAdapter(this, categoryNames);
        directionsRC.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        directionsRC.setLayoutManager(llm);
    }
}
