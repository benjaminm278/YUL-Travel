package com.example.yultravel.Spots;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yultravel.R;

public class MoreSpots extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_spots);

        Intent i = getIntent();
        String a = i.getStringExtra(SpotsActivity.DATE_RANGE_EXTRA);
        Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
    }
}
