package com.example.yultravel.Plans;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.yultravel.Database.ProfileRepository;
import com.example.yultravel.Database.YULTravelDatabase;

import java.util.List;

public class PlanRepository {
    private PlanDAO mPlanDAO;
    private LiveData<List<Plan>> mAllPlans;

    PlanRepository(Application application){
        YULTravelDatabase db = YULTravelDatabase.getDatabase(application);
        mPlanDAO = db.PlanDAO();
        mAllPlans = mPlanDAO.getAllPlans();
    }
    LiveData<List<Plan>>getAllPlans(){
        return mAllPlans;
    }
    public void insertPlan(Plan plan){
        new insertAsyncTask(mPlanDAO).execute(plan);
    }
    private static class insertAsyncTask extends AsyncTask<Plan,Void,Void>{
        private PlanDAO mAsyncTaskDao;
        insertAsyncTask(PlanDAO dao){
            mAsyncTaskDao =dao;
        }

        @Override
        protected Void doInBackground(Plan... plans) {
            mAsyncTaskDao.insertPlan(plans[0]);
            return null;
        }
    }
}
