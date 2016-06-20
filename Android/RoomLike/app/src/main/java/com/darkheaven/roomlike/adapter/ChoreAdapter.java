package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.GroceryItem;
import com.darkheaven.roomlike.sync.UpdateComplete;
import com.darkheaven.roomlike.sync.UpdateDibs;
import com.darkheaven.roomlike.utils.SP;

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
            holder.objectContainer = (LinearLayout)convertView.findViewById(R.id.text_container);
            holder.objectTitle = (TextView)convertView.findViewById(R.id.object_title);
            holder.objectDetails = (TextView)convertView.findViewById(R.id.object_details);
            holder.completeButton = (Button)convertView.findViewById(R.id.complete_button);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        final Chore object = (Chore)getItem(position);
        if(object.getDibsUser() != null){
            holder.dibsButton.setText(object.getDibsUser().getUserName());
        }else{
            holder.dibsButton.setText("Call Dibs");
        }

        if(object.getCompletedUser() != null){
            holder.completeButton.setText(object.getCompletedUser().getUserName());
            holder.dibsButton.setText("Completed");
        }else{
            holder.completeButton.setText("Complete");
        }

        holder.objectTitle.setText(object.getText());

        StringBuilder details = new StringBuilder();
        /*
         * TODO : handle last user purchase
         */
        holder.objectDetails.setText(details.toString());
        final Button tempDibs = holder.dibsButton;
        holder.dibsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : mark item dibs
                if(object.getCompletedUser() != null || object.getDibsUser() != null){
                    // do nothing
                }else{
                    tempDibs.setText(SP.getString(SP.USER_NAME_KEY));
                    object.setDibsUser(MainActivity.os.getUserByID(SP.getInt(SP.USER_ID_KEY)));
                    new UpdateDibs().execute(object);
                }

            }
        });

        final Button tempComplete = holder.completeButton;
        holder.completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(object.getCompletedUser() != null){
                    // do nothing
                }else{
                    tempComplete.setText(SP.getString(SP.USER_NAME_KEY));
                    object.setDibsUser(MainActivity.os.getUserByID(SP.getInt(SP.USER_ID_KEY)));
                    new UpdateComplete().execute(object);
                }
            }
        });

        holder.objectContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        return convertView;
    }
}
