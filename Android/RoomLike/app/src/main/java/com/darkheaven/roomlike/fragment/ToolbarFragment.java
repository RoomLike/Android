package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/26/16.
 */
public class ToolbarFragment extends Fragment {
    public static final String ACTIVE_SCREEN = "active_screen";
    public static ToolbarFragment newInstance(int screen){
        ToolbarFragment fragment = new ToolbarFragment();
        Bundle args = new Bundle();
        args.putInt(ACTIVE_SCREEN, screen);
        fragment.setArguments(args);
        return fragment;
    }

    public ToolbarFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_toolbar, container, false);
        int screen = getArguments().getInt(ACTIVE_SCREEN);

        return rootView;
    }
}
