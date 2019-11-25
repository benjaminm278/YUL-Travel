package com.example.yultravel.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract interface ProfileDAO {

    @Insert
    void insert(Profile profile);

    @Query("select * from profile_table")
    LiveData<List<Profile>> getAllProfiles();
}
