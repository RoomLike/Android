package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class BaseObject {
    Group group;
    User maker;
    String text;
    BaseObject object;
    User assignedUser;
    User dibsUser;
    User completedUser;

    public BaseObject() {

    }

    public BaseObject(Group group, User maker, String text, BaseObject object, User assignedUser, User dibsUser, User completedUser) {
        this.group = group;
        this.maker = maker;
        this.text = text;
        this.object = object;
        this.assignedUser = assignedUser;
        this.dibsUser = dibsUser;
        this.completedUser = completedUser;
    }

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

    public BaseObject getObject() {
        return object;
    }

    public void setObject(BaseObject objectID) {
        this.object = objectID;
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
}
