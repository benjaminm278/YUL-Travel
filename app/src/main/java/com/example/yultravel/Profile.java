package com.example.yultravel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Profile {
    private String mName;

    enum Countries{
        Canada, USA, China, UK, France, Portugal, Mexico
    }
    Countries Country;

    private boolean[] mInterest;

    private Date vacationStart;
    private Date vacationEnd;

    public Profile(String name, String country, boolean[] intrest){

        mName = name;

        Country = Countries.valueOf(country);

        mInterest = intrest;
    }
}
