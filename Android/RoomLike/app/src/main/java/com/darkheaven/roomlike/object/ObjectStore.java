package com.darkheaven.roomlike.object;

import android.renderscript.BaseObj;

import com.darkheaven.roomlike.activity.RLApplication;
import com.darkheaven.roomlike.database.DBOpenHelper;
import com.darkheaven.roomlike.utils.L;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ObjectStore {
    public Group group = new Group();
    public ArrayList<BaseObject> objects = new ArrayList<>();
    public DBOpenHelper helper;

    public ObjectStore(){
        helper = new DBOpenHelper(RLApplication.getContext());
    }

    public void addUserToGroup(User user){
        group.addUserToGroup(user);
    }

    public void addObject(BaseObject object){
        boolean exists = false;
        for(BaseObject o : objects){
            if(o.getObjectID() == object.getObjectID()) {
                exists = true;
                break;
            }
        }
        if(!exists) {
            objects.add(object);
            helper.insertObject(object);
        }
    }

    public User getUserByName(String name){
        for(User u : group.getUsers().values()){
            if(u.getUserName().equals(name)){
                return u;
            }
        }
        return null;
    }

    public User getUserByID(int userID){
        for(User u : group.getUsers().values()){
            if(u.getUserID() == userID){
                return u;
            }
        }
        return null;
    }

    public void updateObject(BaseObject object){
        boolean found = false;
        for(int i = 0; i < objects.size() && !found; i++){
            if(objects.get(i).getObjectID() == object.getObjectID()){
                objects.set(i, object);
                /*
                TODO : update object in DB
                helper.updateObject();
                 */
                found = true;
            }
        }
    }

    public ArrayList<BaseObject> getChores(){
        ArrayList<BaseObject> list = new ArrayList<>();
        for(BaseObject boo : objects){
            if(boo instanceof Chore){
                list.add(boo);
            }
        }
        return list;
    }

    public ArrayList<BaseObject> getGroceries(){
        ArrayList<BaseObject> list = new ArrayList<>();
        for(BaseObject boo : objects){
            if(boo instanceof GroceryItem){
                list.add(boo);
            }
        }
        return list;
    }

    public ArrayList<BaseObject> getPayments(){
        ArrayList<BaseObject> list = new ArrayList<>();
        for(BaseObject boo : objects){
            if(boo instanceof Payment){
                list.add(boo);
            }
        }
        return list;
    }

    public ArrayList<BaseObject> getMessages(){
        ArrayList<BaseObject> list = new ArrayList<>();
        for(BaseObject boo : objects){
            if(boo instanceof Message){
                list.add(boo);
            }
        }
        return list;
    }
}
