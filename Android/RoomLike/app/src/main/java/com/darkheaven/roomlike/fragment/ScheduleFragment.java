package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.listener.ScheduleListener;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ScheduleFragment extends BaseFragment {
    Spinner frequencySpinner;
    CheckBox anyCB;
    LinearLayout dayOfMonthContainer;
    NumberPicker dayOfMonthNP;
    LinearLayout monthOfYearContainer;
    NumberPicker monthOfYearNP;
    LinearLayout yearContainer;
    NumberPicker yearNP;
    LinearLayout hourContainer;
    NumberPicker hourNP;
    LinearLayout minuteContainer;
    NumberPicker minuteNP;
    public static final String FREQUENCY_SPINNER = "FREQUENCY_SPINNER";
    public static final String ANY_CHECKBOX = "ANY_CHECKBOX";
    public static final String DAY_OF_MONTH_CONTAINER = "DAY_OF_MONTH_CONTAINER";
    public static final String DAY_OF_MONTH_NUMBER_PICKER = "DAY_OF_MONTH_NUMBER_PICKER";
    public static final String MONTH_OF_YEAR_CONTAINER = "MONTH_OF_YEAR_CONTAINER";
    public static final String MONTH_OF_YEAR_NUMBER_PICKER = "MONTH_OF_YEAR_NUMBER_PICKER";
    public static final String YEAR_CONTAINER = "YEAR_CONTAINER";
    public static final String YEAR_NUMBER_PICKER = "YEAR_NUMBER_PICKER";
    public static final String HOUR_CONTAINER = "HOUR_CONTAINER";
    public static final String HOUR_NUMBER_PICKER = "HOUR_NUMBER_PICKER";
    public static final String MINUTE_CONTAINER = "MINUTE_CONTAINER";
    public static final String MINUTE_NUMBER_PICKER = "MINUTE_NUMBER_PICKER";

    public ScheduleFragment(){}

    public static BaseFragment newInstance(int screen){
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putInt(MainActivity.ACTIVE_SCREEN, screen);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        // grocery doesn't display all scheduling options
        frequencySpinner = (Spinner)rootView.findViewById(R.id.frequency_list);
        anyCB = (CheckBox)rootView.findViewById(R.id.checkbox_any);
        dayOfMonthContainer = (LinearLayout)rootView.findViewById(R.id.day_of_month_container);
        dayOfMonthNP = (NumberPicker)rootView.findViewById(R.id.day_of_month_picker);
        monthOfYearContainer = (LinearLayout)rootView.findViewById(R.id.month_of_year_container);
        monthOfYearNP = (NumberPicker)rootView.findViewById(R.id.month_of_year_picker);
        yearContainer = (LinearLayout)rootView.findViewById(R.id.year_container);
        yearNP = (NumberPicker)rootView.findViewById(R.id.year_picker);
        hourContainer = (LinearLayout)rootView.findViewById(R.id.hour_container);
        hourNP = (NumberPicker)rootView.findViewById(R.id.hour_picker);
        minuteContainer = (LinearLayout)rootView.findViewById(R.id.minute_container);
        minuteNP = (NumberPicker)rootView.findViewById(R.id.minute_picker);
        registerViews();
        ((ScheduleListener)listener).setScreen(getArguments().getInt(MainActivity.ACTIVE_SCREEN));
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        listener.registerView(FREQUENCY_SPINNER, frequencySpinner);
        listener.registerView(ANY_CHECKBOX, anyCB);
        listener.registerView(DAY_OF_MONTH_CONTAINER, dayOfMonthContainer);
        listener.registerView(DAY_OF_MONTH_NUMBER_PICKER, dayOfMonthNP);
        listener.registerView(MONTH_OF_YEAR_CONTAINER, monthOfYearContainer);
        listener.registerView(MONTH_OF_YEAR_NUMBER_PICKER, monthOfYearNP);
        listener.registerView(YEAR_CONTAINER, yearContainer);
        listener.registerView(YEAR_NUMBER_PICKER, yearNP);
        listener.registerView(HOUR_CONTAINER, hourContainer);
        listener.registerView(HOUR_NUMBER_PICKER, hourNP);
        listener.registerView(MINUTE_CONTAINER, minuteContainer);
        listener.registerView(MINUTE_NUMBER_PICKER, minuteNP);
    }
}
