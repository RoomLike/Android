package com.darkheaven.roomlike.object;

import com.darkheaven.roomlike.frequency.Frequency;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tinyiota on 5/27/16.
 */
public class Schedule {
    Frequency frequency;
    BaseObject object;
    ArrayList<User> users;
    Date nextDate;
    Date lastDate;
    ArrayList<Day> daysOfWeek;
    int dayOfMonth;
    int monthOfYear;
    int year;
    int hour;
    int minute;
    boolean isAM;
    int repeatEvery;
    boolean anyDay;


    public Schedule() {
        users = new ArrayList<>();
        daysOfWeek = new ArrayList<>();
    }

    public Schedule(Frequency frequency, BaseObject object, ArrayList<User> users, Date nextDate, Date lastDate, ArrayList<Day> daysOfWeek, int dayOfMonth, int monthOfYear, int year, int hour, int minute, boolean isAM, int repeatEvery, boolean anyDay) {
        this.frequency = frequency;
        this.object = object;
        this.users = users;
        this.nextDate = nextDate;
        this.lastDate = lastDate;
        this.daysOfWeek = daysOfWeek;
        this.dayOfMonth = dayOfMonth;
        this.monthOfYear = monthOfYear;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.isAM = isAM;
        this.repeatEvery = repeatEvery;
        this.anyDay = anyDay;
    }

    public void scheduleEvents(int numberDays){
        // TODO : if scheduled events don't already exist, create them for the next XX days
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public BaseObject getObject() {
        return object;
    }

    public void setObject(BaseObject object) {
        this.object = object;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public ArrayList<Day> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(ArrayList<Day> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(int monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isAM() {
        return isAM;
    }

    public void setIsAM(boolean isAM) {
        this.isAM = isAM;
    }

    public int getRepeatEvery() {
        return repeatEvery;
    }

    public void setRepeatEvery(int repeatEvery) {
        this.repeatEvery = repeatEvery;
    }

    public boolean isAnyDay() {
        return anyDay;
    }

    public void setAnyDay(boolean anyDay) {
        this.anyDay = anyDay;
    }
}
