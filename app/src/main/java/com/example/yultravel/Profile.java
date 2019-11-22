package com.example.yultravel;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public Profile(){
        mName = "John Doe";
        Country = Countries.Canada;
        mInterest = new boolean[]{false, false, false, false, false};
        vacationStart = new Date();
        vacationEnd = new Date();
    }

    public String getmName(){
        return mName;
    }

    public boolean[] getmInterest() {
        return mInterest;
    }

    public String getCountry(){
        return Country.toString();
    }

    public void toastTest(){
        Toast.makeText(ctx, mName, Toast.LENGTH_LONG).show();
    }
}
