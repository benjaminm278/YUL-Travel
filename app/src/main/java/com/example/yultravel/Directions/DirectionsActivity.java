package com.example.yultravel.Directions;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.util.ArrayList;
import java.util.Collections;

public class DirectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        // String arraylist
        ArrayList<Category> categoryNames = new ArrayList();
        categoryNames.add(new Category("Airport", R.drawable.ic_airplane_teal_36dp));
        categoryNames.add(new Category("Landmarks", R.drawable.ic_airplane_teal_36dp));
        categoryNames.add(new Category("Metro", R.drawable.ic_airplane_teal_36dp));
        categoryNames.add(new Category("Parks", R.drawable.ic_airplane_teal_36dp));
        categoryNames.add(new Category("Restaurants", R.drawable.ic_airplane_teal_36dp));
        categoryNames.add(new Category("Shops", R.drawable.ic_airplane_teal_36dp));
        /*categoryNames.add("Restaurants");
        categoryNames.add("Metro (subway)");
        categoryNames.add("Parks");
        categoryNames.add("Shops");
        categoryNames.add("Stadium");*/

        // RecyclerView code
        RecyclerView directionsRC = findViewById(R.id.directionsCategoryRecyclerView);
        DirectionsCategoryAdapter adapter = new DirectionsCategoryAdapter(this, categoryNames);
        directionsRC.setAdapter(adapter);
        directionsRC.setLayoutManager(new LinearLayoutManager(this));
    }
}
