package com.example.breezapp.models;

public class Thing {
    private String status;
    private String label;
    private String location;

    public Thing(String location) {
        this.location=location;
       // this.status = status;
        //this.label = label;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }
}
