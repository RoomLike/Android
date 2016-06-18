package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Chore extends BaseObject {
    Schedule schedule;

    public Chore(){}

    public Chore(Group group, User maker, String text, User assignedUser, User dibsUser, User completedUser, Schedule schedule, String timeCreated){
        super(group, maker, text, assignedUser, dibsUser, completedUser, timeCreated);
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
