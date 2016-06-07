package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.darkheaven.roomlike.fragment.ScheduleFragment;
import com.darkheaven.roomlike.frequency.*;
import com.darkheaven.roomlike.object.Schedule;
import com.darkheaven.roomlike.utils.L;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/28/16.
 */
public class ScheduleListener extends BaseListener implements AdapterView.OnItemSelectedListener {
    private int screen;
    static Schedule schedule;
    Frequency frequency;

    public ScheduleListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get("ADD_BUTTON"))){
            // TODO : link to add grocery item screen
        }
    }

    @Override
    public void initViews() {
        // TODO : init frequency_spinner
        ArrayList<String> frequencyList = FrequencyStore.getFrequencyStrings();
        for(int i = 0; i < frequencyList.size(); i++){
            L.e(frequencyList.get(i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, frequencyList);
        ((Spinner)(views.get(ScheduleFragment.FREQUENCY_SPINNER))).setAdapter(arrayAdapter);
        ((Spinner)(views.get(ScheduleFragment.FREQUENCY_SPINNER))).setOnItemSelectedListener(this);

        ((NumberPicker)views.get(ScheduleFragment.DAY_OF_MONTH_NUMBER_PICKER)).setMinValue(1);
        ((NumberPicker)views.get(ScheduleFragment.DAY_OF_MONTH_NUMBER_PICKER)).setMaxValue(31);

        ((NumberPicker)views.get(ScheduleFragment.HOUR_NUMBER_PICKER)).setMinValue(0);
        ((NumberPicker)views.get(ScheduleFragment.HOUR_NUMBER_PICKER)).setMaxValue(23);

        ((NumberPicker)views.get(ScheduleFragment.MINUTE_NUMBER_PICKER)).setMinValue(0);
        ((NumberPicker)views.get(ScheduleFragment.MINUTE_NUMBER_PICKER)).setMaxValue(59);

        ((NumberPicker)views.get(ScheduleFragment.MONTH_OF_YEAR_NUMBER_PICKER)).setMinValue(1);
        ((NumberPicker)views.get(ScheduleFragment.MONTH_OF_YEAR_NUMBER_PICKER)).setMaxValue(12);

        ((NumberPicker)views.get(ScheduleFragment.YEAR_NUMBER_PICKER)).setMinValue(2016);
        ((NumberPicker)views.get(ScheduleFragment.YEAR_NUMBER_PICKER)).setMaxValue(2020);

        ((NumberPicker)views.get(ScheduleFragment.REPEAT_EVERY_NUMBER_PICKER)).setMinValue(0);
        ((NumberPicker)views.get(ScheduleFragment.REPEAT_EVERY_NUMBER_PICKER)).setMaxValue(4);
    }

    public void setScreen(int screen){
        this.screen = screen;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //if(view is in frequencylist){
        String frequencyText = parent.getItemAtPosition(position).toString();
        frequency = FrequencyStore.getFrequencyByText(frequencyText);
        /*
        listener.registerView(DAY_OF_MONTH_CONTAINER, dayOfMonthContainer);
        listener.registerView(MONTH_OF_YEAR_CONTAINER, monthOfYearContainer);
        listener.registerView(YEAR_CONTAINER, yearContainer);
        listener.registerView(HOUR_CONTAINER, hourContainer);
        listener.registerView(MINUTE_CONTAINER, minuteContainer);
         */
        if(frequency instanceof Once){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.GONE);
        }else if(frequency instanceof Daily){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof Weekly){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof Monthly){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof Yearly){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof WeekDay){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof Weekend){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof MWF){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }else if(frequency instanceof TTh){
            views.get(ScheduleFragment.DAY_OF_MONTH_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.MONTH_OF_YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.YEAR_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.DAY_OF_WEEK_CONTAINER).setVisibility(View.GONE);
            views.get(ScheduleFragment.HOUR_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.MINUTE_CONTAINER).setVisibility(View.VISIBLE);
            views.get(ScheduleFragment.REPEAT_EVERY_CONTAINER).setVisibility(View.VISIBLE);
        }
        //}else{ // view is in other list

        //}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public Schedule getSchedule(){
        if(schedule == null){
            schedule = new Schedule();
        }
        schedule.setFrequency(frequency);
        schedule.setDayOfMonth(((NumberPicker)views.get(ScheduleFragment.DAY_OF_MONTH_NUMBER_PICKER)).getValue());
        schedule.setAnyDay(((CheckBox) views.get(ScheduleFragment.ANY_CHECKBOX)).isChecked());
        schedule.setHour(((NumberPicker) views.get(ScheduleFragment.HOUR_NUMBER_PICKER)).getValue());
        schedule.setMinute(((NumberPicker) views.get(ScheduleFragment.MINUTE_NUMBER_PICKER)).getValue());
        schedule.setMonthOfYear(((NumberPicker) views.get(ScheduleFragment.MONTH_OF_YEAR_NUMBER_PICKER)).getValue());
        schedule.setRepeatEvery(((NumberPicker) views.get(ScheduleFragment.REPEAT_EVERY_NUMBER_PICKER)).getValue());
        schedule.setYear(((NumberPicker) views.get(ScheduleFragment.YEAR_NUMBER_PICKER)).getValue());
        return schedule;
    }
}
