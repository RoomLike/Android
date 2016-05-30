package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/26/16.
 */
public class MessageFragment extends BaseFragment {
    LinearLayout messageContainer;
    EditText newMessage;
    Button sendButton;

    public static BaseFragment newInstance(){
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    public MessageFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_messages, container, false);
        messageContainer = (LinearLayout)rootView.findViewById(R.id.message_container);
        newMessage = (EditText)rootView.findViewById(R.id.new_message);
        sendButton = (Button)rootView.findViewById(R.id.send_button);
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView("MESSAGE_CONTAINER", messageContainer);
        listener.registerView("NEW_MESSAGE_EDIT_TEXT", newMessage);
        listener.registerView("SEND_BUTTON", sendButton);
    }
}
