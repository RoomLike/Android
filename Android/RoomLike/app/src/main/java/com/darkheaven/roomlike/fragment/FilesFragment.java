package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/28/16.
 */
public class FilesFragment extends BaseFragment {
    public FilesFragment(){}

    public static BaseFragment newInstance(){
        FilesFragment fragment = new FilesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_files, container, false);
        return rootView;
    }

    @Override
    public void registerViews() {

    }
}
