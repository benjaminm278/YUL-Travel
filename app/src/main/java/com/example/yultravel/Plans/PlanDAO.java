package com.example.yultravel.Plans;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlanDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPlan(Plan plan);
    @Query("DELETE from plan_table")
    void detleAll();
    @Query("SELECT * from plan_table")
   LiveData<List<Plan>> getAllPlans();
}
