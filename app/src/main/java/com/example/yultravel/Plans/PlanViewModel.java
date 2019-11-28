package com.example.yultravel.Plans;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanViewModel extends AndroidViewModel {
    private PlanRepository mRepository;
    private LiveData<List<Plan>>mAllPlans;
    public PlanViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PlanRepository(application);
        mAllPlans = mRepository.getAllPlans();
    }
    LiveData<List<Plan>> getAllPlans(){
        return mAllPlans;
    }
    public void insert(Plan plan){
        mRepository.insertPlan(plan);
    }
}
