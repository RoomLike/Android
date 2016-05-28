package com.darkheaven.roomlike.frequency;

/**
 * Created by tinyiota on 5/27/16.
 */
public class Frequency {
    int frequencyID;
    String frequencyText;

    public Frequency() {
    }

    public Frequency(int frequencyID, String frequencyText) {
        this.frequencyID = frequencyID;
        this.frequencyText = frequencyText;
    }

    public int getFrequencyID() {
        return frequencyID;
    }

    public void setFrequencyID(int frequencyID) {
        this.frequencyID = frequencyID;
    }

    public String getFrequencyText() {
        return frequencyText;
    }

    public void setFrequencyText(String frequencyText) {
        this.frequencyText = frequencyText;
    }
}
