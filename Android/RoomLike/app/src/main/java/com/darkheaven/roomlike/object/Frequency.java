package com.darkheaven.roomlike.object;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/26/16.
 */
public class Frequency {
    private static ArrayList<String> frequencies;
    private static Frequency instance;

    public Frequency(){
        instance = this;
        frequencies = new ArrayList<>();
    }

    public static String getFrequency(int index){
        if(instance == null){
            instance = new Frequency();
            instance.init();
        }
        return frequencies.get(index);
    }

    public void init(){
        frequencies.add("Once");
        frequencies.add("Daily");
        frequencies.add("M-F");
        frequencies.add("MWF");
        frequencies.add("TTh");
        frequencies.add("Weekends");
        frequencies.add("Weekly");
        frequencies.add("Monthly");
        frequencies.add("Yearly");
    }
}
