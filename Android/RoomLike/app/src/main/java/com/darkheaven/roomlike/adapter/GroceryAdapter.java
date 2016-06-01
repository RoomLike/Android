package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.GroceryItem;

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
            convertView = inflater.inflate(R.layout.row, parent, false);
            holder = new ViewHolder();
            holder.dibsButton = (Button)convertView.findViewById(R.id.dibs_button);
            holder.objectContainer = (LinearLayout)convertView.findViewById(R.id.text_container);
            holder.objectTitle = (TextView)convertView.findViewById(R.id.object_title);
            holder.objectDetails = (TextView)convertView.findViewById(R.id.object_details);
            holder.completeButton = (Button)convertView.findViewById(R.id.complete_button);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        GroceryItem item = (GroceryItem)getItem(position);
        holder.objectTitle.setText(item.getText());

        StringBuilder details = new StringBuilder();
        details.setLength(0);
        /*
         * TODO : handle last user purchase
         */
        details.append(item.getSeverity());
        holder.objectDetails.setText(details.toString());

        if(item.getDibsUser() != null){
            holder.dibsButton.setText(item.getDibsUser().getUserName());
        }else{
            holder.dibsButton.setText("Call Dibs");
        }

        holder.dibsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : mark item dibs

                // TODO : notify other users of dibs

            }
        });

        if(item.getCompletedUser() != null){
            holder.completeButton.setText(item.getCompletedUser().getUserName());
        }else{
            holder.completeButton.setText("Complete");
        }
        holder.completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : mark item complete

                // TODO : notify other users of complete

            }
        });

        return convertView;
    }


}
