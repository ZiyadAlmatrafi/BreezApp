package com.example.breezapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StateDescription {



    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("readOnly")
    @Expose
    private Boolean readOnly;
    @SerializedName("options")
    @Expose
    private List<Object> options = null;


    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }
}
