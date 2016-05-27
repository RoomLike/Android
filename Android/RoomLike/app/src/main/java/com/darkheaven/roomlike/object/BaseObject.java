package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class BaseObject {
    Group group;
    User makerID;
    String text;
    int objectID;

    public BaseObject() {

    }

    public BaseObject(Group group, User makerID, String text, int objectID) {
        this.group = group;
        this.makerID = makerID;
        this.text = text;
        this.objectID = objectID;
    }

    public Group getGroupID() {
        return group;
    }

    public void setGroupID(Group groupID) {
        this.group = groupID;
    }

    public User getMakerID() {
        return makerID;
    }

    public void setMakerID(User makerID) {
        this.makerID = makerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }
}
