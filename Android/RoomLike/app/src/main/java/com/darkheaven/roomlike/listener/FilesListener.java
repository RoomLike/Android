package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.adapter.GroceryAdapter;

/**
 * Created by tinyiota on 5/28/16.
 */
public class FilesListener extends BaseListener {
    public FilesListener(Context context) {
        super(context);
    }

    @Override
    public void initViews() {
        // TODO : create messages list


        (views.get("SEND_BUTTON")).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get("ADD_BUTTON"))){
            // TODO : link to add grocery item screen
        }
    }
}
