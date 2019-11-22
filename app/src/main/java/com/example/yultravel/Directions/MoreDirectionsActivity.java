package com.example.yultravel.Directions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MoreDirectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_direction_categories);

        Intent i = getIntent();
        String category = i.getStringExtra(DirectionsCategoryAdapter.CATEGORY_EXTRA);
        TextView t = findViewById(R.id.categoryTextView);
        t.setText(category);

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Decarie Hot Dogs", "953 Boulevard Decarie"));
        locations.add(new Location("McDonalds", "910 Cote-Vertu"));
        locations.add(new Location("Mikes", "7101 Cote-Vertu"));
        locations.add(new Location("Abid's hot spicy chicken", "999 Volcano Land"));
        locations.add(new Location("Sliced Dice", "777 Casino"));

        RecyclerView v = findViewById(R.id.categoryItemsRecyclerView);
        MoreDirectionsCategoryAdapter adapter =
                new MoreDirectionsCategoryAdapter(this, locations);
        v.setAdapter(adapter);
        v.setLayoutManager(new LinearLayoutManager(this));
    }
}
