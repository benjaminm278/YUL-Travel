package com.example.yultravel.Database.Profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository mRepository;
    private LiveData<List<Profile>> mProfiles;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ProfileRepository(application);
        mProfiles = mRepository.getProfile();
    }

    public void insert(Profile prof) {
        mRepository.insert(prof);
    }

    public LiveData<List<Profile>> getProfile() {
        return mProfiles;
    }
}
