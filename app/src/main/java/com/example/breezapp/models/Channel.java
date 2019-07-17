package com.example.breezapp.models;

public class Channel {
    private String uid ;
    private String id ;
    private String channelTypeUID ;
    private String itemType ;
    private String kind ;
    private String label ;
    private String description ;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
