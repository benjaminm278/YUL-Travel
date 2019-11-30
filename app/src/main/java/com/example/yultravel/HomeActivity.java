package com.example.yultravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yultravel.Directions.DirectionsActivity;
import com.example.yultravel.Plans.PlansActivity;
import com.example.yultravel.Spots.SpotsActivity;
import com.example.yultravel.Weather.WeatherActivity;

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

    /**
     * Inflates the menu on the app bar
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.app_menu, menu);
        return true;
    }

    /**
     * Opens activity based on menu item clicked
     * @param item
     */
    public void openMenuActivity(MenuItem item) {
        Intent activity;

        switch (item.getItemId()) {
            case R.id.settingsConstraintLayout:
                activity = new Intent(this, SettingsActivity.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

        startActivity(activity);
    }
}
