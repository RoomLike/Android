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
    public SettingsFragment(){}

    public static BaseFragment newInstance(){
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {

    }
}
