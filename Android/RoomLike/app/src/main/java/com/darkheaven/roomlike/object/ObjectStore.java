package com.darkheaven.roomlike.object;

import android.renderscript.BaseObj;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.activity.RLApplication;
import com.darkheaven.roomlike.database.DBOpenHelper;
import com.darkheaven.roomlike.utils.L;
import com.darkheaven.roomlike.utils.SP;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ObjectStore {
    public Group group;
    public ArrayList<BaseObject> objects = new ArrayList<>();
    public DBOpenHelper helper;
    public ArrayList<HelpItem> helpItems;

    public ObjectStore(){
        helper = new DBOpenHelper(RLApplication.getContext());
    }

    public void init(){
        group = new Group();
        if(helper.userExists()){
            helper.initObjects();
        }
        loadHelpItems();
    }

    public void setGroup(Group group){
        SP.saveInt(SP.GROUP_ID_KEY, group.getGroupID());
        this.group = group;
    }

    public void addUserToGroup(User user){
        boolean exists = false;
        for(User u : group.getUsers().values()){
            if(u.getUserID() == user.getUserID()){
                exists = true;
            }
        }
        if(!exists) {
            group.addUserToGroup(user);
            helper.insertUser(user);
        }
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

    public void clear(){
        group = new Group();
        objects = new ArrayList<>();
        helper.deleteTableData();
    }

    public void loadHelpItems(){
        helpItems = helper.getHelpItems();
    }

    public void addHelpItem(HelpItem item){
        boolean exists = false;
        for(int i = 0; i < helpItems.size(); i++){
            if(helpItems.get(i).getHeader().equals(item.getHeader())){
                exists = true;
            }
        }
        if(!exists){
            helpItems.add(item);
        }
    }
}
