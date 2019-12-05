package com.example.yultravel.Plans;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
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
    public static final int NEW_PLAN_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        // RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
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
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Plan myPlan = adapter.getPlanAtPosition(position);
                String plan = myPlan.getTitle();
               Toast.makeText(PlansActivity.this,"Deleting: "+plan ,Toast.LENGTH_LONG).show();
                mPlanViewModel.deletPlan(myPlan);

            }
        });
        helper.attachToRecyclerView(recyclerView);

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

        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*
        if (id == R.id.clear_data) {
            // Add a toast just for confirmation
            Toast.makeText(this, "Clearing the data...",
                    Toast.LENGTH_SHORT).show();

            // Delete the existing data
            mPlanViewModel.deleteAll();
            return true;
        }
        */
        return super.onOptionsItemSelected(item);

    }
}
