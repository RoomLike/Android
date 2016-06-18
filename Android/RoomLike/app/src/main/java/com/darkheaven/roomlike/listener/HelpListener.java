package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.adapter.HelpAdapter;
import com.darkheaven.roomlike.fragment.HelpFragment;
import com.darkheaven.roomlike.object.HelpItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tinyiota on 6/17/16.
 */
public class HelpListener extends BaseListener {
    HelpAdapter adapter;

    public HelpListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initViews() {
        ArrayList<String> headers = new ArrayList<>();
        HashMap<String,ArrayList<HelpItem> > details = new HashMap<>();
        for(int i = 0; i < MainActivity.os.helpItems.size(); i++){
            headers.add(MainActivity.os.helpItems.get(i).getHeader());
            ArrayList<HelpItem> item = new ArrayList<>();
            item.add(MainActivity.os.helpItems.get(i));
            details.put(MainActivity.os.helpItems.get(i).getHeader(), item);
        }

        adapter = new HelpAdapter(context, headers, details);
        ((ExpandableListView)views.get(HelpFragment.HELP_LIST)).setAdapter(adapter);
    }
}
