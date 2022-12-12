package com.example.myofficeproject.Model;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class VersionApiModel implements Serializable {

    @SerializedName("App_version")
     String App_version;

    public String getApp_version() {
        return App_version;
    }

    public void setApp_version(String app_version) {
        App_version = app_version;
    }
}
