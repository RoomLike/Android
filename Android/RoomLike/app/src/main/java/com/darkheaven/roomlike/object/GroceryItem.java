package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class GroceryItem extends BaseObject {
    public GroceryItem(){}

    public GroceryItem(Group group, User maker, String text, BaseObject object, User assignedUser, User dibsUser, User completedUser){
        super(group, maker, text, object, assignedUser, dibsUser, completedUser);
    }
}
