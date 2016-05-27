package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.darkheaven.roomlike.listener.BaseListener;

/**
 * Created by tinyiota on 5/26/16.
 */
public class BaseFragment extends Fragment {
    BaseListener listener;
    View rootView;

    public BaseFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setListener(BaseListener listener){
        this.listener = listener;
    }

    public void registerViews(){

    }
}
