package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.adapter.MessageAdapter;
import com.darkheaven.roomlike.fragment.MessageFragment;
import com.darkheaven.roomlike.object.Message;
import com.darkheaven.roomlike.sync.SendMessage;
import com.darkheaven.roomlike.utils.SP;

/**
 * Created by tinyiota on 5/27/16.
 */
public class MessageListener extends BaseListener {
    MessageAdapter adapter;

    public MessageListener(Context context) {
        super(context);
    }

    @Override
    public void initViews(){
        adapter = new MessageAdapter(context, MainActivity.os.getMessages());
        ((ListView)views.get(MessageFragment.MESSAGE_CONTAINER)).setAdapter(adapter);
        ((EditText)views.get(MessageFragment.NEW_MESSAGE_EDIT_TEXT)).setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get(MessageFragment.SEND_BUTTON))){
            String messageText = ((EditText)views.get(MessageFragment.NEW_MESSAGE_EDIT_TEXT)).getText().toString();
            if(!messageText.equals("")){
                SendMessage sendTask = new SendMessage(context);
                sendTask.setListener(this);
                String url = "http://10.0.2.2:8080/insert_message/"
                        + Integer.toString(SP.getInt(SP.GROUP_ID_KEY)) + "/"
                        + Integer.toString(SP.getInt(SP.USER_ID_KEY)) + "/"
                        + messageText.replaceAll(" ", "|");
                sendTask.execute(url);
            }
        }
    }

    public void messageGetSuccess(){
        initViews();
    }

    public void messageSentSuccess(){
        initViews();
    }
}
