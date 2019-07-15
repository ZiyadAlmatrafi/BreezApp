package com.example.breezapp.models;

public class Rooms {

    private int img_id;
    private String location;

    public Rooms(int img_id, String location) {
        this.img_id = img_id;
        this.location = location;
    }

    public int getImg_id() {
        return img_id;
    }

    public String getLocation() {
        return location;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

