package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class BaseObject {
    Group group;
    User maker;
    String text;
    int objectID;
    User assignedUser;
    User dibsUser;
    User completedUser;
    String timeCreated;

    public BaseObject() {

    }

    public BaseObject(Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser, String timeCreated) {
        this.group = group;
        this.maker = maker;
        this.text = text;
        this.assignedUser = assignedUser;
        this.dibsUser = dibsUser;
        this.completedUser = completedUser;
        this.timeCreated = timeCreated;
    }

    public void update(BaseObject object){}

    public Group getGroupID() {
        return group;
    }

    public void setGroupID(Group groupID) {
        this.group = groupID;
    }

    public User getMaker() {
        return maker;
    }

    public void setMaker(User maker) {
        this.maker = maker;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public User getDibsUser() {
        return dibsUser;
    }

    public void setDibsUser(User dibsUser) {
        this.dibsUser = dibsUser;
    }

    public User getCompletedUser() {
        return completedUser;
    }

    public void setCompletedUser(User completedUser) {
        this.completedUser = completedUser;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}
