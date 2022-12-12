package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CompanyDetails implements Serializable {

    @SerializedName("LogDboyLoctionMeter")
    private int LogDboyLoctionMeter;


    public int getLogDboyLoctionMeter() {
        return LogDboyLoctionMeter;
    }

    public void setLogDboyLoctionMeter(int logDboyLoctionMeter) {
        LogDboyLoctionMeter = logDboyLoctionMeter;
    }
}
