package com.example.breezapp.models;

import java.util.ArrayList;
import java.util.List;

public class ThingResponse {
    private ArrayList<Thing> things;

    public ThingResponse(ArrayList<Thing> things) {
        this.things = things;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }
}
