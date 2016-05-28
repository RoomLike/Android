package com.darkheaven.roomlike.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;

/**
 * Created by tinyiota on 5/26/16.
 */
public class ToolbarFragment extends Fragment implements View.OnClickListener {
    Button choreButton;
    Button groceryButton;
    Button messagesButton;
    Button paymentButton;
    Button filesButton;

    public static ToolbarFragment newInstance(int screen){
        ToolbarFragment fragment = new ToolbarFragment();
        Bundle args = new Bundle();
        args.putInt(MainActivity.ACTIVE_SCREEN, screen);
        fragment.setArguments(args);
        return fragment;
    }

    public ToolbarFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_toolbar, container, false);
        int screen = getArguments().getInt(MainActivity.ACTIVE_SCREEN);
        messagesButton = (Button)rootView.findViewById(R.id.messages_button);
        choreButton = (Button)rootView.findViewById(R.id.chores_button);
        groceryButton = (Button)rootView.findViewById(R.id.grocery_button);
        paymentButton = (Button)rootView.findViewById(R.id.payments_button);
        filesButton = (Button)rootView.findViewById(R.id.files_button);

        messagesButton.setBackgroundColor(Color.WHITE);
        choreButton.setBackgroundColor(Color.WHITE);
        groceryButton.setBackgroundColor(Color.WHITE);
        paymentButton.setBackgroundColor(Color.WHITE);
        filesButton.setBackgroundColor(Color.WHITE);
        switch (screen) {
            // replace with more malleable methods
            case 0:
                messagesButton.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                choreButton.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                groceryButton.setBackgroundColor(Color.BLUE);
                break;
            case 3:
                paymentButton.setBackgroundColor(Color.BLUE);
                break;
            case 4:
                filesButton.setBackgroundColor(Color.BLUE);
        }
        messagesButton.setOnClickListener(this);
        choreButton.setOnClickListener(this);
        groceryButton.setOnClickListener(this);
        paymentButton.setOnClickListener(this);
        filesButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(messagesButton)){
            MainActivity.pager.setCurrentItem(0);
        }else if(v.equals(choreButton)){
            MainActivity.pager.setCurrentItem(1);
        }else if(v.equals(groceryButton)){
            MainActivity.pager.setCurrentItem(2);
        }else if(v.equals(paymentButton)){
            MainActivity.pager.setCurrentItem(3);
        }else if(v.equals(filesButton)){
            MainActivity.pager.setCurrentItem(4);
        }
    }
}
