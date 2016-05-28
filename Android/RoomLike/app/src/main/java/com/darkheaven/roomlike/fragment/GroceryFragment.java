package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/26/16.
 */
public class GroceryFragment extends BaseFragment {
    ListView listView;
    Button addButton;

    public static BaseFragment newInstance(){
        GroceryFragment fragment = new GroceryFragment();
        return fragment;
    }

    public GroceryFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grocery, container, false);
        listView = (ListView)rootView.findViewById(R.id.list);
        addButton = (Button)rootView.findViewById(R.id.add_button);

        return rootView;
    }

    @Override
    public void registerViews(){
        listener.registerView("LIST_VIEW", listView);
        listener.registerView("ADD_BUTTON", addButton);
    }
}
