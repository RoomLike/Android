package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ChoreEditFragment extends BaseFragment {
    public ChoreEditFragment(){}

    public static BaseFragment newInstance(){
        ChoreEditFragment fragment = new ChoreEditFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chore, container, false);
        return rootView;
    }

    @Override
    public void registerViews() {

    }
}
