package com.example.breezapp.models;

import java.util.ArrayList;

public class StateDescription {

   private int minimum ;
   private int maximum ;
   private int step ;
   private ArrayList<StateOption> options;


    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public ArrayList<StateOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<StateOption> options) {
        this.options = options;
    }
}
