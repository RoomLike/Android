package com.darkheaven.roomlike.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.ChoreListener;

/**
 * Created by tinyiota on 5/26/16.
 */
public class ChoreFragment extends BaseFragment {
    SwipeRefreshLayout swipeLayout;
    ListView listView;
    Button addButton;

    public static BaseFragment newInstance(){
        ChoreFragment fragment = new ChoreFragment();
        return fragment;
    }

    public ChoreFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chore, container, false);
        swipeLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe_layout);
        listView = (ListView)rootView.findViewById(R.id.list);
        addButton = (Button)rootView.findViewById(R.id.add_button);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews(){
        listener.registerView("LIST_VIEW", listView);
        listener.registerView("ADD_BUTTON", addButton);
    }
}
