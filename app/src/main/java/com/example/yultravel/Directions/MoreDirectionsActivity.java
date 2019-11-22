package com.example.yultravel.Directions;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        if (category.compareToIgnoreCase("airport") == 1) {
            locations.add(new Location("Montreal International Airport", "YUL Airport"));
        }
        else if (category.compareToIgnoreCase("metro (subway)") == 1) {
            locations.add(new Location("Find nearest metro station", "Nearest metro station"));
            locations.add(new Location("Orange line station", "Nearest orange line metro station"));
            locations.add(new Location("Yellow line station", "Nearest yellow line metro station"));
            locations.add(new Location("Green line station", "Nearest green line metro station"));
            locations.add(new Location("Blue line station", "Nearest blue line metro station"));
        }
        else if (category.compareToIgnoreCase("parks") == 1) {
            locations.add(new Location("Find nearest metro station", "Nearest metro station"));
            locations.add(new Location("Decarie Hot Dogs", "953 Boulevard Decarie"));
        }
        else if (category.compareToIgnoreCase("restaurants") == 1) {
            locations.add(new Location("Find nearest metro station", "Nearest metro station"));
            locations.add(new Location("Decarie Hot Dogs", "953 Boulevard Decarie"));
            locations.add(new Location("McDonalds", "910 Cote-Vertu"));
            locations.add(new Location("Mikes", "7101 Cote-Vertu"));
            locations.add(new Location("Abid's hot spicy chicken", "999 Volcano Land"));
            locations.add(new Location("Sliced Dice", "777 Casino"));
        }
        else if (category.compareToIgnoreCase("shops") == 1) {
            locations.add(new Location("Find nearest shop", "Nearest metro station"));
            locations.add(new Location("Decarie Hot Dogs", "953 Boulevard Decarie"));
            locations.add(new Location("McDonalds", "910 Cote-Vertu"));
            locations.add(new Location("Mikes", "7101 Cote-Vertu"));
            locations.add(new Location("Abid's hot spicy chicken", "999 Volcano Land"));
            locations.add(new Location("Sliced Dice", "777 Casino"));
        }
        else if (category.compareToIgnoreCase("stadium") == 1) {
            locations.add(new Location("Find nearest metro station", "Nearest metro station"));
            locations.add(new Location("Olympic stadium", "910 Cote-Vertu"));
            locations.add(new Location("Mikes", "7101 Cote-Vertu"));
            locations.add(new Location("Abid's hot spicy chicken", "999 Volcano Land"));
            locations.add(new Location("Sliced Dice", "777 Casino"));
        }

        RecyclerView v = findViewById(R.id.categoryItemsRecyclerView);
        MoreDirectionsCategoryAdapter adapter =
                new MoreDirectionsCategoryAdapter(this, locations);
        v.setAdapter(adapter);
        v.setLayoutManager(new LinearLayoutManager(this));
    }
}
