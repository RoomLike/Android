package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.adapter.ChoreAdapter;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.sync.GetObjects;
import com.darkheaven.roomlike.utils.L;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ChoreListener extends BaseListener {
    public ChoreListener(Context context) {
        super(context);
    }

    @Override
    public void initViews() {
        adapter = new ChoreAdapter(context, MainActivity.os.getChores());
        L.e(views.get("LIST_VIEW").toString());
        ((ListView)(views.get("LIST_VIEW"))).setAdapter(adapter);
        (views.get("LIST_VIEW")).setOnLongClickListener(this);
        views.get("ADD_BUTTON").setOnClickListener(this);
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, position + " clicked.", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public void onClick(View v) {
        if(v.equals(views.get("ADD_BUTTON"))){
            MainActivity.changeScreen(MainActivity.CHORE_SCREEN_EDIT);
        }
    }

    @Override
    public void onRefresh() {
        new GetObjects(this).execute("Chore");
    }
}
