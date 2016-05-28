package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.darkheaven.roomlike.adapter.GroceryAdapter;
import com.darkheaven.roomlike.object.BaseObject;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class GroceryListener extends BaseListener {
    public GroceryListener(Context context) {
        super(context);
    }

    @Override
    public void initViews() {
        // code to add interests from DB
        adapter = new GroceryAdapter(context, new ArrayList<BaseObject>());
        ((ListView)views.get("LIST_VIEW")).setAdapter(adapter);
        (views.get("ADD_BUTTON")).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get("ADD_BUTTON"))){
            // TODO : link to add grocery item screen
        }
    }
}
