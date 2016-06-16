package com.darkheaven.roomlike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.object.BaseObject;
import com.darkheaven.roomlike.object.Message;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class MessageAdapter  extends BaseAdapter{
    ArrayList<BaseObject> items;
    Context context;
    LayoutInflater inflater;

    public MessageAdapter(Context context, ArrayList<BaseObject> items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_message, parent, false);
            holder.messageText = (TextView)convertView.findViewById(R.id.message_text);
            holder.messageMaker = (TextView)convertView.findViewById(R.id.message_sender);
            holder.messageTime = (TextView)convertView.findViewById(R.id.message_time);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Message message = (Message)getItem(position);
        holder.messageText.setText(message.getText());
        holder.messageMaker.setText(message.getMaker().getUserName());
        holder.messageTime.setText(message.getMessageTime());
        return convertView;
    }

    private class ViewHolder{
        TextView messageText;
        TextView messageTime;
        TextView messageMaker;
    }
}
