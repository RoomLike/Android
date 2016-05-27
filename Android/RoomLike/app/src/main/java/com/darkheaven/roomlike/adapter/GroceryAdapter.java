package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        ViewHolder holder = initializeHolder(convertView, parent);

        GroceryItem item = (GroceryItem)getItem(position);
        holder.itemTitle.setText(item.getText());

        StringBuilder details = new StringBuilder();
        /*
         * TODO : handle last user purchase
         */
        holder.itemDetails.setText(details.toString());

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
