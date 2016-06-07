package com.darkheaven.roomlike.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.fragment.GroceryEditFragment;
import com.darkheaven.roomlike.object.Chore;
import com.darkheaven.roomlike.object.GroceryItem;
import com.darkheaven.roomlike.utils.SP;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/28/16.
 */
public class GroceryEditListener extends BaseListener implements AdapterView.OnItemSelectedListener {
    int objectID;
    String assignedToSelected;

    public GroceryEditListener(Context context) {
        super(context);
        objectID = -1000;
    }

    @Override
    public void initViews() {
        ArrayList<String> users = MainActivity.os.group.getUsersNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, users);
        (((Spinner) views.get(GroceryEditFragment.ASSIGNED_TO_SPINNER))).setAdapter(adapter);
        (((Spinner) views.get(GroceryEditFragment.ASSIGNED_TO_SPINNER))).setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        assignedToSelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v.equals(views.get(GroceryEditFragment.SUBMIT_BUTTON))){
            if(objectID == -1000){
                // add new
                addNewObject();
                MainActivity.changeScreen(MainActivity.GROCERY_SCREEN);
            }else{
                updateObject();
            }
        }
    }

    public void setObjectID(int objectID){
        this.objectID = objectID;
    }

    public void addNewObject(){
        GroceryItem item = new GroceryItem();
        item.setText(((EditText) views.get(GroceryEditFragment.TITLE_FIELD)).getText().toString());
        item.setSeverity(((EditText) views.get(GroceryEditFragment.IMPORTANCE_EDIT_TEXT)).getText().toString());
        item.setMaker(MainActivity.os.getUserByName(SP.getString(SP.USER_NAME_KEY)));
        if(!assignedToSelected.equals("")) {
            item.setAssignedUser(MainActivity.os.getUserByName(assignedToSelected));
        }
        MainActivity.os.addObject(item);
    }

    public void updateObject(){

    }
}
