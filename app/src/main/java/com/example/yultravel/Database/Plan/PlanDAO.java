package com.example.yultravel.Database.Plan;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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
    @Query("SELECT * from plan_table LIMIT 1")
    Plan[] getAnyPlan();
    @Delete
    void deletePlan(Plan plan);
    @Update
    void updatePlan(Plan plan);
}
