package com.example.breezapp.models;

import com.google.gson.annotations.SerializedName;

public class Thing {
    private String status;

    @SerializedName("label")
    private String label;

    @SerializedName("location")
    private String location;



    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
