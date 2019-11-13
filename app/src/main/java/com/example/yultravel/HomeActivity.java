package com.example.yultravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * Opens an activity based on the image button that was clicked
     * @param view
     */
    public void openActivity(View view) {
        //Toast.makeText(this, view.getId() + " ", Toast.LENGTH_SHORT).show();

        // Variables
        Intent activityIntent;

        switch (view.getId()) {
            case R.id.setupActivityButton:
                activityIntent = new Intent(this, SetupActivity.class);
                break;
            case R.id.weatherImageButton:
                activityIntent = new Intent(this, WeatherActivity.class);
                break;
            case R.id.plansImageButton:
                activityIntent = new Intent(this, PlansActivity.class);
                break;
            case R.id.spotsImageButton:
                activityIntent = new Intent(this, SpotsActivity.class);
                break;
            case R.id.directionsImageButton:
                activityIntent = new Intent(this, DirectionsActivity.class);
                break;
            default:
                activityIntent = new Intent();
                break;
        }

        startActivity(activityIntent);
    }
}
