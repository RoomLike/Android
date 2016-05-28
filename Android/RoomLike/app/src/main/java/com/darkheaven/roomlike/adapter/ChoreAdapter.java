package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.GroceryItem;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ChoreAdapter extends ListAdapter {
    public ChoreAdapter(Context context, ArrayList<BaseObject> items) {
        super(context, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row, parent, false);
            holder = new ViewHolder();
            holder.dibsButton = (Button)convertView.findViewById(R.id.dibs_button);
            holder.objectTitle = (TextView)convertView.findViewById(R.id.object_title);
            holder.objectDetails = (TextView)convertView.findViewById(R.id.object_details);
            holder.completeButton = (Button)convertView.findViewById(R.id.complete_button);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Chore object = (Chore)getItem(position);
        if(object.getDibsUser() != null){
            holder.dibsButton.setText(object.getDibsUser().getUserName());
        }else{
            holder.dibsButton.setText("Call Dibs");
        }

        if(object.getCompletedUser() != null){
            holder.completeButton.setBackgroundColor(Color.RED);
            holder.completeButton.setText(object.getCompletedUser().getUserName());
            holder.dibsButton.setText("Completed");
        }else{
            holder.completeButton.setBackgroundColor(Color.GREEN);
        }

        holder.objectTitle.setText(object.getText());

        StringBuilder details = new StringBuilder();
        /*
         * TODO : handle last user purchase
         */
        holder.objectDetails.setText(details.toString());

        holder.dibsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : mark item dibs

                // TODO : notify other users of dibs

            }
        });

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
