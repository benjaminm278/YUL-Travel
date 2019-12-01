package com.example.yultravel.Plans;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Database.Plan;
import com.example.yultravel.Database.PlanViewModel;
import com.example.yultravel.HomeActivity;
import com.example.yultravel.R;
import com.example.yultravel.Spots.SpotsActivity;
import com.example.yultravel.YULNotification;

import java.util.List;

public class PlansActivity extends HomeActivity {
    private PlanViewModel mPlanViewModel;
    public static final int NEW_PLAN_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PlanAdapter adapter = new PlanAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // View Model
        mPlanViewModel = ViewModelProviders.of(this).get(PlanViewModel.class);
        mPlanViewModel.getAllPlans().observe(this, new Observer<List<Plan>>() {
            @Override
            public void onChanged(List<Plan> plans) {
                adapter.setPlans(plans);
            }
        });
    }

    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_PLAN_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Plan plan = new Plan(data.getStringExtra(PlanFragment.EXTRA_REPLY));
            mPlanViewModel.insert(plan);
        }
        else {
            Toast.makeText(getApplicationContext(), "Not Saved.", Toast.LENGTH_LONG).show();
        }
    }*/

    /**
     * Opens new activity based on button clicked
     * @param view
     */
    public void openNewActivity(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.addPlanButton:
                i = new Intent(this, AddPlanActivity.class);
                break;
            case R.id.mtlEventsButton:
                i = new Intent(this, SpotsActivity.class);
                break;
            default:
                i = null;
        }

        YULNotification y = new YULNotification(this,
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE), "Plan",
                "This is a test");
        y.showNotification();

        startActivity(i);
    }
}
