package com.example.yultravel.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProfileDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Profile profile);

    /**
     * Deletes all rows from table
     */
    @Query("DELETE FROM profile_table")
    void deleteAll();

    @Query("SELECT * FROM profile_table")
    LiveData<List<Profile>> getAllProfiles();



}
