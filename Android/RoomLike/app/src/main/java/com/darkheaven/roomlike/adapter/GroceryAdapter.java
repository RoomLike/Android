package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.GroceryItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class GroceryAdapter extends ListAdapter {

    public GroceryAdapter(Context context, ArrayList<BaseObject> items) {
        super(context, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_grocery, parent, false);
            holder = new ViewHolder();
            holder.dibsButton = (Button)convertView.findViewById(R.id.dibs_button);
            holder.itemTitle = (TextView)convertView.findViewById(R.id.item_title);
            holder.itemDetails = (TextView)convertView.findViewById(R.id.item_details);
            holder.completeButton = (Button)convertView.findViewById(R.id.complete_button);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        GroceryItem item = (GroceryItem)getItem(position);
        holder.itemTitle.setText(item.getText());
        StringBuilder details = new StringBuilder();
        holder.itemDetails.setText(details.toString());
        return convertView;
    }

    private class ViewHolder{
        Button dibsButton;
        TextView itemTitle;
        TextView itemDetails;
        Button completeButton;
    }
}
