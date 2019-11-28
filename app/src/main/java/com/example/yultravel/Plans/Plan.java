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

    public Plan(@NonNull String title){
        this.title =title;

    }

    public String getTitle() {
        return this.title;
    }


}
