package com.darkheaven.roomlike.object;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Group {
    HashMap<Integer,User> users;
    int groupID;
    String groupName;

    public Group(){
        users = new HashMap<>();
    }

    public Group(int groupID, HashMap<Integer,User> users){
        this.groupID = groupID;
        this.users = users;
    }

    public void addUserToGroup(User user){
        user.setGroup(this);
        users.put(user.getUserID(), user);
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

    public ArrayList<String> getUsersNames(){
        ArrayList<String> results = new ArrayList<>();
        for(User u : users.values()){
            results.add(u.getUserName());
        }
        return results;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
