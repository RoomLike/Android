package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/27/16.
 */
public class PaymentEditFragment extends BaseFragment {
    Button submitButton;
    EditText titleField;
    Spinner assignedToSpinner;
    EditText amountText;

    public static final String SUBMIT_BUTTON = "SUBMIT_BUTTON";
    public static final String TITLE_FIELD = "TITLE_FIELD";
    public static final String ASSIGNED_TO_SPINNER = "ASSIGNED_TO_SPINNER";
    public static final String AMOUNT_EDIT_TEXT = "AMOUNT_EDIT_TEXT";

    public PaymentEditFragment(){}

    public static BaseFragment newInstance(){
        PaymentEditFragment fragment = new PaymentEditFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_payment_edit, container, false);
        submitButton = (Button)rootView.findViewById(R.id.submit);
        titleField = (EditText)rootView.findViewById(R.id.title_field);
        assignedToSpinner = (Spinner)rootView.findViewById(R.id.assigned_to_spinner);
        amountText = (EditText)rootView.findViewById(R.id.amount_text);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView(SUBMIT_BUTTON, submitButton);
        listener.registerView(TITLE_FIELD, titleField);
        listener.registerView(ASSIGNED_TO_SPINNER, assignedToSpinner);
        listener.registerView(AMOUNT_EDIT_TEXT, amountText);
        submitButton.setOnClickListener(listener);
    }
}
