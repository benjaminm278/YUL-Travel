package com.example.yultravel.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "plan_table")
public class Plan {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "planName")
    private String title;
    @ColumnInfo(name = "type")
    private String type;

    /*
    @ColumnInfo(name ="planType")
    private String type;

    /*
    @NonNull
    @ColumnInfo(name ="location")
    private String location;

    @NonNull
    @ColumnInfo(name ="date")
    private String date;

    @NonNull
    @ColumnInfo(name ="time")
    private String time;*/

    public Plan(@NonNull String title, String type/*, @NonNull String location,
                @NonNull String date, @NonNull String time*/) {
        this.title = title;
        this.type = type;/*
        this.location = location;
        this.date = date;
        this.time = time;*/
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }
/*
    public String getLocation() {
        return this.location;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }*/
}
