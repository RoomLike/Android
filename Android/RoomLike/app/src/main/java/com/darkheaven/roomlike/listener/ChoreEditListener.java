package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.fragment.ChoreEditFragment;
import com.darkheaven.roomlike.fragment.ScheduleFragment;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.sync.CreateChore;
import com.darkheaven.roomlike.utils.SP;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/28/16.
 */
public class ChoreEditListener extends BaseListener implements AdapterView.OnItemSelectedListener {
    int objectID;
    String assignedToSelected;

    public ChoreEditListener(Context context) {
        super(context);
        objectID = -1000;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get(ChoreEditFragment.SUBMIT_BUTTON))){
            if(objectID == -1000){
                // add new
                addNewObject();
                MainActivity.changeScreen(MainActivity.CHORE_SCREEN);
            }else{
                updateObject();
            }
        }
    }

    @Override
    public void initViews() {
        ArrayList<String> users = new ArrayList<>();
        users.add("");
        users.addAll(MainActivity.os.group.getUsersNames());
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
        chore.setText(((EditText) views.get(ChoreEditFragment.TITLE_FIELD)).getText().toString());
        chore.setSchedule(((ScheduleListener) MainActivity.scheduleListener).getSchedule());
        chore.getSchedule().setObject(chore);
        chore.setMaker(MainActivity.os.getUserByName(SP.getString(SP.USER_NAME_KEY)));
        if(!assignedToSelected.equals("")) {
            chore.setAssignedUser(MainActivity.os.getUserByName(assignedToSelected));
        }

        CreateChore choreTask = new CreateChore(context);
        choreTask.execute();
    }

    public void updateObject(){

    }
}
