package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Message extends BaseObject {
    long messageTime;

    public Message(){}
    public Message(Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser){
        super(group, maker, text, assignedUser, dibsUser, completedUser);
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
