package com.darkheaven.roomlike.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.RLApplication;
import com.darkheaven.roomlike.database.DBOpenHelper;
import com.darkheaven.roomlike.object.BaseObject;

import java.util.ArrayList;

/**
 * Created by tinyiota on 6/20/16.
 */
public class MyRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory {
    Context context;
    private int appWidgetID;
    ArrayList<BaseObject> objects = new DBOpenHelper(RLApplication.getContext()).getWidgetObjects();

    public MyRemoteViewFactory(Context context, Intent intent){
        this.context = context;
        appWidgetID = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews row = new RemoteViews(context.getPackageName(), R.layout.widget_row);
        BaseObject object = objects.get(position);
        row.setTextViewText(R.id.object_title, object.getText());
        return row;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
