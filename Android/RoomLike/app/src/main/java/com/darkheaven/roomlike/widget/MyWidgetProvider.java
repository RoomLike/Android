package com.darkheaven.roomlike.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;

/**
 * Created by tinyiota on 6/20/16.
 */
public class MyWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int i = 0; i < appWidgetIds.length; i++){
            Intent intent = new Intent(context, WidgetService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_main_layout);

            views.setRemoteAdapter(appWidgetIds[i], R.id.widget_list, intent);

            Intent clickIntent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            views.setPendingIntentTemplate(R.id.widget_list, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds[i],views);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();
        }
    }
}
