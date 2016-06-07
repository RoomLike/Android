package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.darkheaven.roomlike.object.Schedule;

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
    LinearLayout dayOfWeekContainer;
    CheckBox dayOfMonday;
    CheckBox dayOfTuesday;
    CheckBox dayOfWednesday;
    CheckBox dayOfThursday;
    CheckBox dayOfFriday;
    CheckBox dayOfSaturday;
    CheckBox dayOfSunday;
    LinearLayout hourContainer;
    NumberPicker hourNP;
    LinearLayout minuteContainer;
    NumberPicker minuteNP;
    LinearLayout repeatEveryContainer;
    NumberPicker repeatEveryNP;
    public static final String FREQUENCY_SPINNER = "FREQUENCY_SPINNER";
    public static final String ANY_CHECKBOX = "ANY_CHECKBOX";
    public static final String DAY_OF_MONTH_CONTAINER = "DAY_OF_MONTH_CONTAINER";
    public static final String DAY_OF_MONTH_NUMBER_PICKER = "DAY_OF_MONTH_NUMBER_PICKER";
    public static final String MONTH_OF_YEAR_CONTAINER = "MONTH_OF_YEAR_CONTAINER";
    public static final String MONTH_OF_YEAR_NUMBER_PICKER = "MONTH_OF_YEAR_NUMBER_PICKER";
    public static final String YEAR_CONTAINER = "YEAR_CONTAINER";
    public static final String YEAR_NUMBER_PICKER = "YEAR_NUMBER_PICKER";
    public static final String DAY_OF_WEEK_CONTAINER = "DAY_OF_WEEK_CONTAINER";
    public static final String HOUR_CONTAINER = "HOUR_CONTAINER";
    public static final String HOUR_NUMBER_PICKER = "HOUR_NUMBER_PICKER";
    public static final String MINUTE_CONTAINER = "MINUTE_CONTAINER";
    public static final String MINUTE_NUMBER_PICKER = "MINUTE_NUMBER_PICKER";
    public static final String REPEAT_EVERY_CONTAINER = "REPEAT_EVERY_CONTAINER";
    public static final String REPEAT_EVERY_NUMBER_PICKER = "REPEAT_EVERY_NUMBER_PICKER";

    public static final String DAY_OF_MONDAY = "DAY_OF_MONDAY";
    public static final String DAY_OF_TUESDAY = "DAY_OF_TUESDAY";
    public static final String DAY_OF_WEDNESDAY = "DAY_OF_WEDNESDAY";
    public static final String DAY_OF_THURSDAY = "DAY_OF_THURSDAY";
    public static final String DAY_OF_FRIDAY = "DAY_OF_FRIDAY";
    public static final String DAY_OF_SATURDAY = "DAY_OF_SATURDAY";
    public static final String DAY_OF_SUNDAY = "DAY_OF_SUNDAY";


    public ScheduleFragment(){}

    public static BaseFragment newInstance(){
        ScheduleFragment fragment = new ScheduleFragment();
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
        dayOfWeekContainer = (LinearLayout)rootView.findViewById(R.id.day_of_week_container);
        dayOfMonday = (CheckBox)rootView.findViewById(R.id.monday_cb);
        dayOfTuesday = (CheckBox)rootView.findViewById(R.id.tuesday_cb);
        dayOfWednesday = (CheckBox)rootView.findViewById(R.id.wednesday_cb);
        dayOfThursday = (CheckBox)rootView.findViewById(R.id.thursday_cb);
        dayOfFriday = (CheckBox)rootView.findViewById(R.id.friday_cb);
        dayOfSaturday = (CheckBox)rootView.findViewById(R.id.saturday_cb);
        dayOfSunday = (CheckBox)rootView.findViewById(R.id.sunday_cb);
        hourContainer = (LinearLayout)rootView.findViewById(R.id.hour_container);
        hourNP = (NumberPicker)rootView.findViewById(R.id.hour_picker);
        minuteContainer = (LinearLayout)rootView.findViewById(R.id.minute_container);
        minuteNP = (NumberPicker)rootView.findViewById(R.id.minute_picker);
        repeatEveryContainer = (LinearLayout)rootView.findViewById(R.id.repeat_every_container);
        repeatEveryNP = (NumberPicker)rootView.findViewById(R.id.repeat_every_picker);
        registerViews();
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
        listener.registerView(DAY_OF_WEEK_CONTAINER, dayOfWeekContainer);
        listener.registerView(DAY_OF_MONDAY, dayOfMonday);
        listener.registerView(DAY_OF_TUESDAY, dayOfTuesday);
        listener.registerView(DAY_OF_WEDNESDAY, dayOfWednesday);
        listener.registerView(DAY_OF_THURSDAY, dayOfThursday);
        listener.registerView(DAY_OF_FRIDAY, dayOfFriday);
        listener.registerView(DAY_OF_SATURDAY, dayOfSaturday);
        listener.registerView(DAY_OF_SUNDAY, dayOfSunday);
        listener.registerView(HOUR_CONTAINER, hourContainer);
        listener.registerView(HOUR_NUMBER_PICKER, hourNP);
        listener.registerView(MINUTE_CONTAINER, minuteContainer);
        listener.registerView(MINUTE_NUMBER_PICKER, minuteNP);
        listener.registerView(REPEAT_EVERY_CONTAINER, repeatEveryContainer);
        listener.registerView(REPEAT_EVERY_NUMBER_PICKER, repeatEveryNP);
    }
}
