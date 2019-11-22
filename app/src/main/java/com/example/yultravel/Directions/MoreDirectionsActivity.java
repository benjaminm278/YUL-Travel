package com.example.yultravel.Directions;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yultravel.R;

public class MoreDirectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_direction_categories);

        Intent i = getIntent();
        String category = i.getStringExtra(DirectionsCategoryAdapter.CATEGORY_EXTRA);
    }
}
