package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.adapter.HelpAdapter;

/**
 * Created by tinyiota on 6/17/16.
 */
public class HelpFragment extends BaseFragment {
    ExpandableListView helpList;

    public static final String HELP_LIST = "HELP_LIST";

    public static BaseFragment newInstance(){
        HelpFragment fragment = new HelpFragment();
        return fragment;
    }

    public HelpFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grocery, container, false);
        helpList = (ExpandableListView)rootView.findViewById(R.id.help_list);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView(HELP_LIST, helpList);
    }
}
