package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ChoreEditFragment extends BaseFragment {
    Button submitButton;
    EditText titleField;
    Spinner assignedToSpinner;
    CheckBox notifyWhenDue;
    CheckBox notifyOnCreate;

    public static final String SUBMIT_BUTTON = "SUBMIT_BUTTON";
    public static final String TITLE_FIELD = "TITLE_FIELD";
    public static final String ASSIGNED_TO_SPINNER = "ASSIGNED_TO_SPINNER";
    public static final String NOTIFY_WHEN_DUE = "NOTIFY_WHEN_DUE";
    public static final String NOTIFY_ON_CREATE = "NOTIFY_ON_CREATE";

    public ChoreEditFragment(){}

    public static BaseFragment newInstance(){
        ChoreEditFragment fragment = new ChoreEditFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chore_edit, container, false);
        submitButton = (Button)rootView.findViewById(R.id.submit);
        titleField = (EditText)rootView.findViewById(R.id.title_field);
        assignedToSpinner = (Spinner)rootView.findViewById(R.id.assigned_to_spinner);
        notifyWhenDue = (CheckBox)rootView.findViewById(R.id.send_notification_when_due);
        notifyOnCreate = (CheckBox)rootView.findViewById(R.id.send_notification_on_create);

        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView(SUBMIT_BUTTON, submitButton);
        listener.registerView(TITLE_FIELD, titleField);
        listener.registerView(ASSIGNED_TO_SPINNER, assignedToSpinner);
        listener.registerView(NOTIFY_WHEN_DUE, notifyWhenDue);
        listener.registerView(NOTIFY_ON_CREATE, notifyOnCreate);
        submitButton.setOnClickListener(listener);
    }
}
