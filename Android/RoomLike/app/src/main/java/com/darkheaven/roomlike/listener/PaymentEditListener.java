package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.fragment.ChoreEditFragment;
import com.darkheaven.roomlike.object.Chore;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/28/16.
 */
public class PaymentEditListener extends BaseListener implements AdapterView.OnItemSelectedListener {
    int objectID;
    String assignedToSelected;

    public PaymentEditListener(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get(ChoreEditFragment.SUBMIT_BUTTON))){
            if(objectID == -1000){
                // add new
                addNewObject();
            }else{
                updateObject();
            }
        }
    }

    @Override
    public void initViews() {
        ArrayList<String> users = MainActivity.os.group.getUsersNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, users);
        (((Spinner) views.get(ChoreEditFragment.ASSIGNED_TO_SPINNER))).setAdapter(adapter);
        (((Spinner) views.get(ChoreEditFragment.ASSIGNED_TO_SPINNER))).setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        assignedToSelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void setObjectID(int objectID){
        this.objectID = objectID;
    }

    public void addNewObject(){
        Chore chore = new Chore();
        chore.setSchedule(((ScheduleListener)MainActivity.scheduleListener).getSchedule());
        chore.getSchedule().setObject(chore);
        chore.setAssignedUser(MainActivity.os.getUserByName(assignedToSelected));
        MainActivity.os.addObject(chore);
    }

    public void updateObject(){

    }
}
