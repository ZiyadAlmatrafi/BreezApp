package com.example.breezapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Channel {



        @SerializedName("linkedItems")
        @Expose
        private List<String> linkedItems = null;
        @SerializedName("uid")
        @Expose
        private String uid;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("channelTypeUID")
        @Expose
        private String channelTypeUID;
        @SerializedName("itemType")
        @Expose
        private String itemType;
        @SerializedName("kind")
        @Expose
        private String kind;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("defaultTags")
        @Expose
        private List<Object> defaultTags = null;

    public List<String> getLinkedItems() {
        return linkedItems;
    }

    public void setLinkedItems(List<String> linkedItems) {
        this.linkedItems = linkedItems;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelTypeUID() {
        return channelTypeUID;
    }

    public void setChannelTypeUID(String channelTypeUID) {
        this.channelTypeUID = channelTypeUID;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Object> getDefaultTags() {
        return defaultTags;
    }

    public void setDefaultTags(List<Object> defaultTags) {
        this.defaultTags = defaultTags;
    }
}
