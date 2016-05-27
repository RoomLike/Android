package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.darkheaven.roomlike.activity.MainActivity;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ChoreListener extends BaseListener {
    public ChoreListener(Context context) {
        super(context);
    }

    @Override
    public void initViews() {
        // code to add interests from DB
        adapter = new InterestsMainAdapter(context, TestData.getInstance().getInterests());
        ((ListView)views.get("interestList")).setAdapter(adapter);
        ((Button)views.get("addInterestButton")).setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, position + " clicked.", Toast.LENGTH_SHORT).show();
    }
}
