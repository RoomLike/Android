package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.darkheaven.roomlike.fragment.BaseFragment;

import java.util.HashMap;

/**
 * Created by tinyiota on 5/27/16.
 */
public class BaseListener implements View.OnClickListener, AdapterView.OnItemClickListener {
    HashMap<String,View> views;
    BaseFragment fragment;
    BaseAdapter adapter;
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
}

