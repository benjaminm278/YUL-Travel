package com.example.yultravel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract interface ProfileDAO {

    @Query("select * from myProfile")
    LiveData<List<Profile>> getAllProfiles();
}
