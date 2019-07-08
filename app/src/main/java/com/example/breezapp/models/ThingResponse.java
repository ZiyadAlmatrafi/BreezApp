package com.example.breezapp.models;

import java.util.ArrayList;

public class ThingResponse {
    private Thing[] things;

    public ThingResponse(Thing[] things) {
        this.things = things;
    }

    public Thing[] getThings() {
        return things;
    }
}
