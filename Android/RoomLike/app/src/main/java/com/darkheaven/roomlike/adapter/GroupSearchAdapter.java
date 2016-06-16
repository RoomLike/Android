package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.Group;

import java.util.ArrayList;

/**
 * Created by tinyiota on 6/16/16.
 */
public class GroupSearchAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<Group> groups;
    Context context;

    public GroupSearchAdapter(Context context, ArrayList<Group> groups){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.groups = groups;
    }

    @Override
    public int getCount() {
        return groups.size();
    }

    @Override
    public Object getItem(int position) {
        return groups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_group, parent, false);
            holder = new ViewHolder();
            holder.groupName = (TextView)convertView.findViewById(R.id.group_name);
            holder.usersNames = (TextView)convertView.findViewById(R.id.users_names);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Group group = (Group)getItem(position);
        holder.groupName.setText(group.getGroupID() + " " + group.getGroupName());

        return convertView;
    }

    private class ViewHolder{
        TextView groupName;
        TextView usersNames;
    }
}
