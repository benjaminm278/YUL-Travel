package com.example.yultravel.Directions;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.HomeActivity;
import com.example.yultravel.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MoreDirectionsActivity extends HomeActivity {

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
            locations.add(new Location("Montreal International Airport",
                    "YUL airport - accessible by bus, car and taxi", "YUL Airport"));
        }
        else if (category.compareToIgnoreCase("metro") == 1) {
            locations.add(new Location("Find nearest metro station",
                    "Nearest metro station", "Nearest STM metro station"));
            locations.add(new Location("Orange line station",
                    "Nearest orange line metro station", "Montreal ligne orange"));
            locations.add(new Location("Yellow line station",
                    "Nearest yellow line metro station", "Montreal ligne jaune"));
            locations.add(new Location("Green line station",
                    "Nearest green line metro station", "Montreal ligne verte"));
            locations.add(new Location("Blue line station",
                    "Nearest blue line metro station", "Montreal ligne bleue"));
        }
        else if (category.compareToIgnoreCase("parks") == 1) {
            locations.add(new Location("Find nearby parks",
                    "Places to relax and play", "Montreal park"));
            locations.add(new Location("Parc Lafontaine",
                    "Nearest metro station", "STM Orange line metro station"));
        }
        else if (category.compareToIgnoreCase("restaurants") == 1) {
            locations.add(new Location("Find nearby restaurants",
                    "Feeling hungry? Find restaurants around you", "Nearby Montreal Restaurants"));
            locations.add(new Location("Decarie Hot Dogs",
                    "953 Boulevard Decarie", "STM Orange line metro station"));
        }
        else if (category.compareToIgnoreCase("shops") == 1) {
            locations.add(new Location("Find nearest shop",
                    "Explore the exquisite shops!", "Nearby Montreal shops"));
            locations.add(new Location("",
                    "953 Boulevard Decarie", "932 Saint Croix Ave"));
        }
        else if (category.compareToIgnoreCase("landmarks") == 1) {
            locations.add(new Location("Find nearby stadiums",
                    "Watch a game", "Montreal stadium"));
            locations.add(new Location("Olympic stadium",
                    "Home of the 1976 Summer Olympics!", "4141 Avenue Pierre-De Coubertin"));
        }

        RecyclerView v = findViewById(R.id.categoryItemsRecyclerView);
        MoreDirectionsCategoryAdapter adapter =
                new MoreDirectionsCategoryAdapter(this, getSupportFragmentManager(), locations);
        v.setAdapter(adapter);
        v.setLayoutManager(new LinearLayoutManager(this));
    }
}
