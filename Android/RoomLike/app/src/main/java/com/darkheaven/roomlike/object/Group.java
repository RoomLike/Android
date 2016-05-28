package com.darkheaven.roomlike.object;

import java.util.HashMap;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Group {
    HashMap<Integer,User> users;
    int groupID;

    public Group(){
        users = new HashMap<>();
    }

    public Group(int groupID, HashMap<Integer,User> users){
        this.groupID = groupID;
        this.users = users;
    }

    public void addUserToGroup(User user){
        int highest = 0;
        for(int uID : users.keySet()){
            if(uID > highest){
                highest = uID;
            }
        }
        user.setGroup(this);
        users.put(highest + 1, user);
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, User> users) {
        this.users = users;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
