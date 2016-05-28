package com.darkheaven.roomlike.frequency;

/**
 * Created by tinyiota on 5/27/16.
 */
public class Weekend extends Frequency {
    public Weekend(){
        setFrequencyText("Weekend");
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);

        return getFrequencyText();
    }
}
