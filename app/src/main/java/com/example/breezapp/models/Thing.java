package com.example.breezapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Thing {
    @SerializedName("statusInfo")
    @Expose
    private StatusInfo statusInfo;
    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("bridgeUID")
    @Expose
    private String bridgeUID;
    @SerializedName("UID")
    @Expose
    private String uID;
    @SerializedName("thingTypeUID")
    @Expose
    private String thingTypeUID;
    @SerializedName("channels")
    @Expose
    private List<Channel> channels ;
    @SerializedName("location")
    @Expose
    private String location;

    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBridgeUID() {
        return bridgeUID;
    }

    public void setBridgeUID(String bridgeUID) {
        this.bridgeUID = bridgeUID;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getThingTypeUID() {
        return thingTypeUID;
    }

    public void setThingTypeUID(String thingTypeUID) {
        this.thingTypeUID = thingTypeUID;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
