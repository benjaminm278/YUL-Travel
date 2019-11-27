package com.example.yultravel.Plans;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface PlanDAO {
    @Insert
    void insert(Plan plan);
    @Delete
    @Update
    void detleAll();
}
