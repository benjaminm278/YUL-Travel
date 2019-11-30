package com.example.yultravel.Plans;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.HomeActivity;
import com.example.yultravel.R;

import java.util.ArrayList;

public class PlansActivity extends HomeActivity {
    RecyclerView recyclerView;
    ArrayList<Plan> planArrayList;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
        Button btnAdd = findViewById(R.id.buttonAddPlan);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new PlanFragment();
                fragment.show(getSupportFragmentManager(),"Add");

            }
        });



    }

    private void initializeData() {
        planArrayList = new ArrayList<>();
        planArrayList.add(new Plan("Hiking"));
        planArrayList.add(new Plan("Biking"));

    }
    private void initializeAdapter() {
        PlanAdapter adapter = new PlanAdapter(this, planArrayList);
        recyclerView.setAdapter(adapter);

    }
}
