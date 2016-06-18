package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class GroceryItem extends BaseObject {
    String severity;

    public GroceryItem(){}

    public GroceryItem(Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser, String severity, String timeCreated){
        super(group, maker, text, assignedUser, dibsUser, completedUser, timeCreated);
        this.severity = severity;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
