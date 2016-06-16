package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import com.darkheaven.roomlike.dialog.BaseDialog;
import com.darkheaven.roomlike.dialog.JoinGroupDialog;
import com.darkheaven.roomlike.fragment.SettingsFragment;

/**
 * Created by tinyiota on 5/31/16.
 */
public class SettingsListener extends BaseListener {
    BaseDialog dialog;
    public SettingsListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get(SettingsFragment.JOIN_GROUP_BUTTON))){
            Toast.makeText(context, "JoinGroupPressed.", Toast.LENGTH_SHORT).show();
            dialog = new JoinGroupDialog(v.getContext());
            dialog.init();
            dialog.show();
        }
    }

    @Override
    public void initViews() {
        super.initViews();
    }
}
