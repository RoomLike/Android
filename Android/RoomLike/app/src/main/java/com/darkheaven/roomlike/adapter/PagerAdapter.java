package com.darkheaven.roomlike.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.darkheaven.roomlike.activity.MainActivity;

/**
 * Created by tinyiota on 5/26/16.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        return MainActivity.fragments.get(arg0);
    }

    @Override
    public int getCount() {
        return MainActivity.fragments.size();
    }

}
