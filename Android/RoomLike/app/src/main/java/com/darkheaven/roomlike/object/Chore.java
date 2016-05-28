package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Chore extends BaseObject {
    Frequency frequency;

    public Chore(){}

    public Chore(Group group, User maker, String text, BaseObject object, User assignedUser, User dibsUser, User completedUser, Frequency frequency){
        super(group, maker, text, object, assignedUser, dibsUser, completedUser);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
