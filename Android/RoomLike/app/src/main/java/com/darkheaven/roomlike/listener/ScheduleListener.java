package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;

/**
 * Created by tinyiota on 5/28/16.
 */
public class ScheduleListener extends BaseListener {
    private int screen;

    public ScheduleListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get("ADD_BUTTON"))){
            // TODO : link to add grocery item screen
        }
    }

    @Override
    public void initViews() {
        // TODO : init frequency_spinner
        

    }

    public void setScreen(int screen){
        this.screen = screen;
    }
}
