package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.BaseObject;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<BaseObject> items;

    public ListAdapter(Context context, ArrayList<BaseObject> items){
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public class ViewHolder{
        Button dibsButton;
        TextView objectTitle;
        TextView objectDetails;
        Button completeButton;
    }
}