package com.example.yultravel.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profile_table") // Create table for entity
public class Profile{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "person_name") // Name of column
    private String mName;

    public Profile(@NonNull String name) {
        this.mName = name;
        //Country = Countries.valueOf(country);
        //mInterest = intrest;
    }

    public String getName() {
        return this.mName;
    }

    /*
    enum Countries {
        Canada, USA, China, UK, France, Portugal, Mexico
    }

    /*
    @NonNull
    @ColumnInfo(name = "Country of origin")
    Countries Country;

    @ColumnInfo(name = "interest")
    private boolean[] mInterest;

    /*
    private Date vacationStart;
    private Date vacationEnd;*/
}
