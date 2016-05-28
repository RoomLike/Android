package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;

import com.darkheaven.roomlike.activity.MainActivity;

/**
 * Created by tinyiota on 5/28/16.
 */
public class ChoreEditListener extends BaseListener {
    public ChoreEditListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get("ADD_BUTTON"))){
            // TODO : link to add chore screen
            MainActivity.changeScreen(MainActivity.CHORE_SCREEN_EDIT);
        }
    }
}
