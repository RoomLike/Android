package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ScheduleFragment extends BaseFragment {
    public static int screen;

    public ScheduleFragment(){}

    public static BaseFragment newInstance(int screen){
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putInt(MainActivity.ACTIVE_SCREEN, screen);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chore, container, false);
        int screen = getArguments().getInt(MainActivity.ACTIVE_SCREEN);
        // grocery doesn't display all scheduling options

        return rootView;
    }
}
