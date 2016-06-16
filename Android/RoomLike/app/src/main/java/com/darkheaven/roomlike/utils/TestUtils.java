package com.darkheaven.roomlike.utils;

import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.object.*;

/**
 * Created by tinyiota on 5/27/16.
 */
public class TestUtils {
    public static void init(){
        // users

        MainActivity.os.addUserToGroup(new User(1, "Curtis"));
        MainActivity.os.addUserToGroup(new User(2, "Sophia"));
        MainActivity.os.addUserToGroup(new User(3, "Travis"));
        MainActivity.os.addUserToGroup(new User(4, "Karyn"));

        // objects
        // Chore:
        //      int objectID, Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser, Frequency frequency
        MainActivity.os.addObject(new Chore(MainActivity.os.group, MainActivity.os.group.getUsers().get(1), "Vacuum", null, MainActivity.os.group.getUsers().get(1), MainActivity.os.group.getUsers().get(1), new Schedule()));
        MainActivity.os.addObject(new Chore(MainActivity.os.group, MainActivity.os.group.getUsers().get(2), "Dishes", null, null, null, new Schedule()));
        MainActivity.os.addObject(new Chore(MainActivity.os.group, MainActivity.os.group.getUsers().get(1), "Walk Dogs", null, null, MainActivity.os.group.getUsers().get(2), new Schedule()));
        MainActivity.os.addObject(new Chore(MainActivity.os.group, MainActivity.os.group.getUsers().get(3), "Dust", null, MainActivity.os.group.getUsers().get(1), null, new Schedule()));
        MainActivity.os.addObject(new Chore(MainActivity.os.group, MainActivity.os.group.getUsers().get(3), "Kill Weeds", null, MainActivity.os.group.getUsers().get(3), null, new Schedule()));
        MainActivity.os.addObject(new Chore(MainActivity.os.group, MainActivity.os.group.getUsers().get(2), "Do Things", null, null, MainActivity.os.group.getUsers().get(2), new Schedule()));

        // GroceryItem:
        //      int objectID, Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser, String severity
        MainActivity.os.addObject(new GroceryItem(MainActivity.os.group, MainActivity.os.group.getUsers().get(3), "Toilet Paper", null, MainActivity.os.group.getUsers().get(2), null, "1 more roll"));

        // Payment:
        //      int objectID, Group group, User makerID, String text, User assignedUser, User dibsUser, User completedUser, User toUser, User fromUser, double amount, Frequency frequency
        MainActivity.os.addObject(new Payment(MainActivity.os.group, MainActivity.os.group.getUsers().get(1), "Rent", null, null, null, MainActivity.os.group.getUsers().get(1), MainActivity.os.group.getUsers().get(2), 400.00, new Schedule()));

        // Message:
        //      int objectID, Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser
        MainActivity.os.addObject(new Message(MainActivity.os.group, MainActivity.os.group.getUsers().get(1), "Hey, i'm going to ks", null, null, null));

    }
}
