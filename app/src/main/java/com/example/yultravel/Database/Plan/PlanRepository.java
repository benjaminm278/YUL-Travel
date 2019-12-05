package com.example.yultravel.Database.Plan;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.yultravel.Database.YULTravelDatabase;

import java.util.List;

public class PlanRepository {
    private PlanDAO mPlanDAO;
    private LiveData<List<Plan>> mAllPlans;

    public PlanRepository(Application application){
        YULTravelDatabase db = YULTravelDatabase.getDatabase(application);
        mPlanDAO = db.PlanDAO();
        mAllPlans = mPlanDAO.getAllPlans();
    }

    public LiveData<List<Plan>>getAllPlans(){
        return mAllPlans;
    }

    public void insertPlan(Plan plan){
        new insertAsyncTask(mPlanDAO).execute(plan);
    }

    private static class insertAsyncTask extends AsyncTask<Plan, Void, Void>{
        private PlanDAO mAsyncTaskDao;
        insertAsyncTask(PlanDAO dao) {
            mAsyncTaskDao = dao;
        }

        /**
         * Executes on another thread
         * @param plans
         * @return
         */
        @Override
        protected Void doInBackground(Plan... plans) {
            mAsyncTaskDao.insertPlan(plans[0]);
            return null;
        }
    }
    public void deleteAll()  {
        new YULTravelDatabase.deleteAllPlansAsyncTask(mPlanDAO).execute();
    }
    private static class deletePlanAsyncTask extends AsyncTask<Plan,Void,Void>{
        private PlanDAO mAsyncTaskDao;
        deletePlanAsyncTask(PlanDAO planDAO){
            mAsyncTaskDao = planDAO;
        }

        @Override
        protected Void doInBackground(Plan... plans) {
            mAsyncTaskDao.deletePlan(plans[0]);
            return null;
        }

    } public void deletePlan(Plan plan){
        new deletePlanAsyncTask(mPlanDAO).execute(plan);
    }

    private static  class updatePlanAsyncTask extends AsyncTask<Plan,Void,Void>{
        private  PlanDAO mAsyncTaskDao;
        updatePlanAsyncTask(PlanDAO dao){
            mAsyncTaskDao=dao;
        }
        @Override
        protected Void doInBackground(Plan... plans) {
            mAsyncTaskDao.deletePlan(plans[0]);
            return null;
        }

    }
    public void updatePlan(Plan plan){
        new updatePlanAsyncTask(mPlanDAO).execute(plan);
    }

}
