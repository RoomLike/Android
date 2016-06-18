package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Payment extends BaseObject{
    User toUser;
    User fromUser;
    double amount;
    Schedule schedule;

    public Payment(){}

    public Payment(Group group, User makerID, String text, User assignedUser, User dibsUser, User completedUser, User toUser, User fromUser, double amount, Schedule schedule, String timeCreated){
        super(group, makerID, text, assignedUser, dibsUser, completedUser, timeCreated);
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.amount = amount;
        this.schedule = schedule;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
