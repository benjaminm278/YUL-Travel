package com.example.yultravel;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DirectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        // RecyclerView code
        RecyclerView directionsRC = findViewById(R.id.directionsCategoryRecyclerView);

    }
}
