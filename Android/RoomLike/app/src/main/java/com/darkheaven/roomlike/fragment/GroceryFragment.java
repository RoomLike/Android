package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/26/16.
 */
public class GroceryFragment extends BaseFragment {
    public static BaseFragment newInstance(){
        GroceryFragment fragment = new GroceryFragment();
        return fragment;
    }

    public GroceryFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grocery, container, false);

        return rootView;
    }
}
