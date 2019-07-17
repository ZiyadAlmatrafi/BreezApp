package com.example.breezapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Thing {

    ThingStatusInfo statusInfo;
    @SerializedName("label")
    private String label;
    @SerializedName("location")
    private String location;
    private ArrayList<Channel> channels;
    private String UID;
    private String bridgeUID;
    private String thingTypeUID;


    public String getLocation() {
        return location;
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ThingStatusInfo getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(ThingStatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getBridgeUID() {
        return bridgeUID;
    }

    public void setBridgeUID(String bridgeUID) {
        this.bridgeUID = bridgeUID;
    }

    public String getThingTypeUID() {
        return thingTypeUID;
    }

    public void setThingTypeUID(String thingTypeUID) {
        this.thingTypeUID = thingTypeUID;
    }
}
