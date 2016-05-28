package com.darkheaven.roomlike.frequency;

/**
 * Created by tinyiota on 5/27/16.
 */
public class Weekly extends Frequency {
    public Weekly(){
        setFrequencyText("Weekly");
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);

        return getFrequencyText();
    }
}
