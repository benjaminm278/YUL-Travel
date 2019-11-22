package com.example.yultravel;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.DatabaseConfiguration;
import androidx.room.Entity;
import androidx.room.InvalidationTracker;
import androidx.room.PrimaryKey;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.Date;

@Entity(tableName = "myProfile") // Create table for entity
public class Profile{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "person_name") // Name of column
    private String mName;



    enum Countries{
        Canada, USA, China, UK, France, Portugal, Mexico
    }

    @NonNull
    @ColumnInfo(name = "Country of origin")
    Countries Country;

    private Context ctx;

    @ColumnInfo(name = "interest")
    private boolean[] mInterest;

    private Date vacationStart;
    private Date vacationEnd;

    public Profile(Context ctx, String name, String country, boolean[] intrest){

        mName = name;

        this.ctx = ctx;

        Country = Countries.valueOf(country);

        mInterest = intrest;

        toastTest();
    }
    
    public void toastTest(){
        Toast.makeText(ctx, mName, Toast.LENGTH_LONG).show();
    }
}
