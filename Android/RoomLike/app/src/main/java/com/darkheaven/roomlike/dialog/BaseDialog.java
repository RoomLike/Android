package com.darkheaven.roomlike.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

/**
 * Created by tinyiota on 5/31/16.
 */
public class BaseDialog extends Dialog implements View.OnClickListener {
    Context context;
    public BaseDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.context = context;
    }

    public void init(){}

    @Override
    public void onClick(View v) {

    }
}
