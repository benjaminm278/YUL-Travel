package com.example.yultravel.Plans;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plan_table")
public class Plan {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name ="planName")
    private String title;
    private String activity;
    private String location;
    public Plan(@NonNull String planName, String activity, String location){
        this.title = planName;
        this.activity=activity;
        this.location=location;
    }

    public String getTitle() {
        return this.title;
    }

    public String getActivity() {
        return activity;
    }

    public String getLocation() {
        return location;
    }
}
