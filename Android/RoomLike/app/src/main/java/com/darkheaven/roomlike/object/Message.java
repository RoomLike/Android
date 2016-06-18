package com.darkheaven.roomlike.object;

import java.util.Date;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Message extends BaseObject {
    String messageTime;

    public Message(){}
    public Message(Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser, String timeCreated){
        super(group, maker, text, assignedUser, dibsUser, completedUser, timeCreated);
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
