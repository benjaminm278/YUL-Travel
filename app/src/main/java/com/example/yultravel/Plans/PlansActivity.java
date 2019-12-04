package com.example.yultravel.Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Database.Plan.Plan;
import com.example.yultravel.Database.Plan.PlanViewModel;
import com.example.yultravel.HomeActivity;
import com.example.yultravel.R;
import com.example.yultravel.Spots.SpotsActivity;

import java.util.List;

public class PlansActivity extends HomeActivity {
    private PlanViewModel mPlanViewModel;
    public static final String PLAN_OPERATION = "op";
    public static final int PLAN_REQUEST_CODE = 1;

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
                i.putExtra(PLAN_OPERATION, "Add");
                startActivityForResult(i, PLAN_REQUEST_CODE);
                break;
            case R.id.mtlEventsButton:
                i = new Intent(this, SpotsActivity.class);
                startActivity(i);
                break;
            default:
                i = new Intent();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLAN_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "F", Toast.LENGTH_LONG).show();
        }
    }
}
