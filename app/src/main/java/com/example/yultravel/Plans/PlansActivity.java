package com.example.yultravel.Plans;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.yultravel.R;

import java.util.List;

public class PlansActivity extends AppCompatActivity {
    RecyclerView recyclerView;
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

        Button btnAdd = findViewById(R.id.buttonAddPlan);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new PlanFragment();
                fragment.show(getSupportFragmentManager(),"Add");
                fragment.startActivityForResult(getIntent(), NEW_PLAN_ACTIVITY_REQUEST_CODE);
            }
        });
    }

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
    }
}
