package com.darkheaven.roomlike.frequency;

/**
 * Created by tinyiota on 5/31/16.
 */
public class Daily extends Frequency {
    public Daily(){
        setFrequencyText("Daily");
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);

        return getFrequencyText();
    }
}
