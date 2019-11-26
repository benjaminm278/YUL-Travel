package com.example.yultravel.Spots;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.yultravel.Weather.CurrentWeatherFragment;
import com.example.yultravel.Weather.HourlyForecastFragment;

public class SpotsPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SpotsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    public SpotsPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TodaysHotSpotFragment();
            case 1: return new ThisWeeksFragment();
            case 2: return new NextWeeksFragment();
            case 3: return new AllTimeSpotsFragment();
            default:
                return null;
        }

    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
