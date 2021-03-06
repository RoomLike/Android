package com.darkheaven.roomlike.frequency;

import java.util.ArrayList;

/**
 * Created by tinyiota on 5/31/16.
 */
public class FrequencyStore {
    private static ArrayList<Frequency> frequencies;

    public static ArrayList<Frequency> getFrequencies(){
        if(frequencies == null){
            init();
        }
        return frequencies;
    }

    public static ArrayList<String> getFrequencyStrings(){
        if(frequencies == null){
            init();
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < frequencies.size(); i++){
            result.add(frequencies.get(i).frequencyText);
        }
        return result;
    }

    public static Frequency getFrequencyByText(String frequencyText){
        if(frequencies == null){
            init();
        }
        Frequency f = null;
        boolean found = false;
        for(int i = 0; i < frequencies.size() && !found; i++){
            if(frequencies.get(i).getFrequencyText().equals(frequencyText)){
                f = frequencies.get(i);
                found = true;
            }
        }
        return f;
    }

    public static Frequency getFrequencyByInt(int value){
        if(frequencies == null){
            init();
        }
        return frequencies.get(value);
    }

    public static void init(){
        frequencies = new ArrayList<>();
        frequencies.add(new Once());
        frequencies.add(new Daily());
        frequencies.add(new Weekly());
        frequencies.add(new Monthly());
        frequencies.add(new Yearly());
        frequencies.add(new WeekDay());
        frequencies.add(new Weekend());
        frequencies.add(new MWF());
        frequencies.add(new TTh());
    }
}
