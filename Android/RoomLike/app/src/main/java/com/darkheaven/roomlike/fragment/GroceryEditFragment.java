package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/27/16.
 */
public class GroceryEditFragment extends BaseFragment {
    public GroceryEditFragment(){}

    public static BaseFragment newInstance(){
        GroceryEditFragment fragment = new GroceryEditFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chore, container, false);
        return rootView;
    }
}
