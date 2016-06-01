package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.darkheaven.roomlike.fragment.ScheduleFragment;
import com.darkheaven.roomlike.frequency.FrequencyStore;
import com.darkheaven.roomlike.object.Schedule;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/28/16.
 */
public class ScheduleListener extends BaseListener implements AdapterView.OnItemSelectedListener {
    private int screen;
    static Schedule schedule;

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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, frequencyList);
        ((Spinner)(views.get(ScheduleFragment.FREQUENCY_SPINNER))).setAdapter(arrayAdapter);
        ((Spinner)(views.get(ScheduleFragment.FREQUENCY_SPINNER))).setOnItemSelectedListener(this);
    }

    public void setScreen(int screen){
        this.screen = screen;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public static Schedule getSchedule(){
        if(schedule == null){
            schedule = new Schedule();
        }

        return schedule;
    }
}
