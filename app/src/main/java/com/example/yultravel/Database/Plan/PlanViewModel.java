package com.example.yultravel.Database.Plan;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanViewModel extends AndroidViewModel {
    private PlanRepository mRepository;
    private LiveData<List<Plan>> mAllPlans;

    public PlanViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PlanRepository(application);
        mAllPlans = mRepository.getAllPlans();
    }

    public LiveData<List<Plan>> getAllPlans(){
        return mAllPlans;
    }

    public void insert(Plan plan){
        mRepository.insertPlan(plan);
    }
    public void deleteAll() {mRepository.deleteAll();}
    public void deletPlan(Plan plan){mRepository.deletePlan(plan); }
    public void updatePlan(Plan plan){mRepository.updatePlan(plan);}
}
