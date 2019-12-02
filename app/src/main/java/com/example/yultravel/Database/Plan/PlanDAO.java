package com.example.yultravel.Database.Plan;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.yultravel.Database.Plan.Plan;

import java.util.List;

@Dao
public interface PlanDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPlan(Plan plan);

    @Query("DELETE from plan_table")
    void deleteAll();

    @Query("SELECT * from plan_table")
    LiveData<List<Plan>> getAllPlans();
}
