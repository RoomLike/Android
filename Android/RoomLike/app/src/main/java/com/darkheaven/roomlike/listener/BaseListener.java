package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.darkheaven.roomlike.adapter.ListAdapter;
import com.darkheaven.roomlike.fragment.BaseFragment;

import java.util.HashMap;

/**
 * Created by tinyiota on 5/27/16.
 */
public class BaseListener implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    HashMap<String,View> views;
    BaseFragment fragment;
    public ListAdapter adapter;
    Context context;

    public BaseListener(Context context){
        this.context = context;
        views = new HashMap<>();
    }

    @Override
    public void onClick(View v) {

    }

    public void registerView(String key, View view){
        views.put(key, view);
    }

    public void setView(BaseFragment fragment){
        this.fragment = fragment;
    }

    public void initViews(){

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onRefresh() {

    }
}

