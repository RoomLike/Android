package com.darkheaven.roomlike.frequency;

/**
 * Created by tinyiota on 5/27/16.
 */
public class TTh extends Frequency {
    public TTh(){
        setFrequencyText("TTh");
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);

        return getFrequencyText();
    }
}
