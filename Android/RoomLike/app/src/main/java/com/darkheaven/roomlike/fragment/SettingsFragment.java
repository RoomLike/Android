package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/31/16.
 */
public class SettingsFragment extends BaseFragment {
    Button createGroup;
    Button joinGroup;

    public static final String CREATE_GROUP_BUTTON = "CREATE_GROUP_BUTTON";
    public static final String JOIN_GROUP_BUTTON = "JOIN_GROUP_BUTTON";

    public SettingsFragment(){}

    public static BaseFragment newInstance(){
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        createGroup = (Button)rootView.findViewById(R.id.create_group);
        joinGroup = (Button)rootView.findViewById(R.id.join_group);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView(CREATE_GROUP_BUTTON, createGroup);
        listener.registerView(JOIN_GROUP_BUTTON, joinGroup);
        createGroup.setOnClickListener(listener);
        joinGroup.setOnClickListener(listener);
    }
}
