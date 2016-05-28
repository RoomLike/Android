package com.darkheaven.roomlike.object;

import android.renderscript.BaseObj;

import com.darkheaven.roomlike.utils.L;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ObjectStore {
    public Group group = new Group();
    public ArrayList<BaseObject> objects = new ArrayList<>();

    public void addUserToGroup(User user){
        group.addUserToGroup(user);
    }

    public void addObject(BaseObject object){
        int highest = 0;
        for(BaseObject o : objects){
            if(o.getObjectID() > highest){
                highest = o.getObjectID();
            }
        }
        object.setObjectID(highest + 1);
        objects.add(object);
    }

    public void markObjectComplete(BaseObject object){
        try{
            objects.remove(object);
        }catch (NullPointerException e){
            L.e("Object does not exist/not found.");
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
}
