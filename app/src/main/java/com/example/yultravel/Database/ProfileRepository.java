package com.example.yultravel.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProfileRepository {

    private ProfileDAO mProfileDao;
    private LiveData<List<Profile>> mAllProfiles;

    public ProfileRepository(Application application){
        YULTravelDatabase db = YULTravelDatabase.getDatabase(application);
        mProfileDao = db.ProfileDAO();
        mAllProfiles = mProfileDao.getAllProfiles();
    }

    LiveData<List<Profile>> getProfile() {
        return mAllProfiles;
    }

    public void insert(Profile prof) {
        new insertAsyncTask(mProfileDao).execute(prof);
    }

    private static class insertAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProfileDAO mAsyncTaskDao;

        insertAsyncTask(ProfileDAO pdao) {
            mAsyncTaskDao = pdao;
        }

        @Override
        protected Void doInBackground(Profile... profiles) {
            mAsyncTaskDao.insert(profiles[0]);
            return null;
        }
    }
}
