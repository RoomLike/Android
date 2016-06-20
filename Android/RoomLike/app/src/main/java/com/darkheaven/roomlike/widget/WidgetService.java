package com.darkheaven.roomlike.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

import com.darkheaven.roomlike.activity.RLApplication;

/**
 * Created by tinyiota on 6/20/16.
 */
public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new MyRemoteViewFactory(getApplicationContext(), intent);
    }
}
