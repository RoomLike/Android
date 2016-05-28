package com.darkheaven.roomlike.object;

import java.util.Date;

/**
 * Created by tinyiota on 5/27/16.
 */
public class ScheduledEvent {
    Date eventDate;
    User user;

    public ScheduledEvent(){
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
