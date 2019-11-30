package com.example.yultravel.Directions;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.HomeActivity;
import com.example.yultravel.R;

import java.util.ArrayList;
import java.util.Collections;

public class DirectionsActivity extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        // String arraylist
        ArrayList<Category> categoryNames = new ArrayList();
        categoryNames.add(new Category("Airport", R.drawable.ic_airplane_teal_36dp));
        categoryNames.add(new Category("Landmarks", R.drawable.landmark_flat_icon));
        categoryNames.add(new Category("Metro", R.drawable.metro_flat_icon));
        categoryNames.add(new Category("Parks", R.drawable.park_flat_icon));
        categoryNames.add(new Category("Restaurants", R.drawable.restaurant_flat_icon));
        categoryNames.add(new Category("Shops", R.drawable.shop_flat_icon));

        // RecyclerView code
        RecyclerView directionsRC = findViewById(R.id.directionsCategoryRecyclerView);
        DirectionsCategoryAdapter adapter = new DirectionsCategoryAdapter(this, categoryNames);
        directionsRC.setAdapter(adapter);
        directionsRC.setLayoutManager(new LinearLayoutManager(this));
    }
}
