package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.HelpItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tinyiota on 6/17/16.
 */
public class HelpAdapter implements ExpandableListAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<String> headers;
    HashMap<String,ArrayList<HelpItem> > details;

    public HelpAdapter(Context context, ArrayList<String> headers, HashMap<String,ArrayList<HelpItem> > details){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.headers = headers;
        this.details = details;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return headers.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return details.get(headers.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headers.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return details.get(headers.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_help_header, parent, false);
        }
        String headerTitle = (String)getGroup(groupPosition);
        TextView headerTitleView = (TextView)convertView.findViewById(R.id.help_header);
        headerTitleView.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_help_detail, parent, false);
        }
        HelpItem item = (HelpItem)getChild(groupPosition, childPosition);
        TextView detailView = (TextView)convertView.findViewById(R.id.help_header);
        detailView.setText(item.getDetail());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
