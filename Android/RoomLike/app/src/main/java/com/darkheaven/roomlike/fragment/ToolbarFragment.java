package com.darkheaven.roomlike.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.utils.TestUtils;

/**
 * Created by tinyiota on 5/26/16.
 */
public class ToolbarFragment extends Fragment implements View.OnClickListener {
    ImageView choreButton;
    ImageView groceryButton;
    ImageView messagesButton;
    ImageView paymentButton;
    ImageView filesButton;
    ImageView settingsButton;

    LinearLayout choreContainer;
    LinearLayout groceryContainer;
    LinearLayout messagesContainer;
    LinearLayout paymentContainer;
    LinearLayout filesContainer;
    LinearLayout settingsContainer;

    TextView choreSpacer;
    TextView grocerySpacer;
    TextView messagesSpacer;
    TextView paymentSpacer;
    TextView filesSpacer;
    TextView settingsSpacer;

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
        messagesButton = (ImageView)rootView.findViewById(R.id.messages_button);
        choreButton = (ImageView)rootView.findViewById(R.id.chores_button);
        groceryButton = (ImageView)rootView.findViewById(R.id.grocery_button);
        paymentButton = (ImageView)rootView.findViewById(R.id.payments_button);
        filesButton = (ImageView)rootView.findViewById(R.id.files_button);
        settingsButton = (ImageView)rootView.findViewById(R.id.settings_button);

        messagesContainer = (LinearLayout)rootView.findViewById(R.id.messages_container);
        choreContainer = (LinearLayout)rootView.findViewById(R.id.chores_container);
        groceryContainer = (LinearLayout)rootView.findViewById(R.id.grocery_container);
        paymentContainer = (LinearLayout)rootView.findViewById(R.id.payments_container);
        filesContainer = (LinearLayout)rootView.findViewById(R.id.files_container);
        settingsContainer = (LinearLayout)rootView.findViewById(R.id.settings_container);

        messagesSpacer = (TextView)rootView.findViewById(R.id.messages_spacer);
        choreSpacer = (TextView)rootView.findViewById(R.id.chores_spacer);
        grocerySpacer = (TextView)rootView.findViewById(R.id.grocery_spacer);
        paymentSpacer = (TextView)rootView.findViewById(R.id.payments_spacer);
        filesSpacer = (TextView)rootView.findViewById(R.id.files_spacer);
        settingsSpacer = (TextView)rootView.findViewById(R.id.settings_spacer);

        messagesSpacer.setBackgroundColor(Color.WHITE);
        choreSpacer.setBackgroundColor(Color.WHITE);
        grocerySpacer.setBackgroundColor(Color.WHITE);
        paymentSpacer.setBackgroundColor(Color.WHITE);
        filesSpacer.setBackgroundColor(Color.WHITE);
        settingsSpacer.setBackgroundColor(Color.WHITE);
        switch (screen) {
            // replace with more malleable methods
            case 0:
                messagesSpacer.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                choreSpacer.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                grocerySpacer.setBackgroundColor(Color.BLUE);
                break;
            case 3:
                paymentSpacer.setBackgroundColor(Color.BLUE);
                break;
            case 4:
                filesSpacer.setBackgroundColor(Color.BLUE);
                break;
            case 5:
                settingsSpacer.setBackgroundColor(Color.BLUE);
        }
        messagesContainer.setOnClickListener(this);
        choreContainer.setOnClickListener(this);
        groceryContainer.setOnClickListener(this);
        paymentContainer.setOnClickListener(this);
        filesContainer.setOnClickListener(this);
        settingsContainer.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(messagesContainer)){
            MainActivity.pager.setCurrentItem(0);
        }else if(v.equals(choreContainer)){
            MainActivity.pager.setCurrentItem(1);
        }else if(v.equals(groceryContainer)){
            MainActivity.pager.setCurrentItem(2);
        }else if(v.equals(paymentContainer)){
            MainActivity.pager.setCurrentItem(3);
        }else if(v.equals(filesContainer)){
            MainActivity.pager.setCurrentItem(4);
        }else if(v.equals(settingsContainer)){
            MainActivity.pager.setCurrentItem(5);
        }
    }
}
