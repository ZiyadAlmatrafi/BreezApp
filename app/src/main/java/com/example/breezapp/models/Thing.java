package com.example.breezapp.models;

public class Thing {
    private String status;
    private String label;


    public Thing(String status, String label) {
        this.status = status;
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }
}
