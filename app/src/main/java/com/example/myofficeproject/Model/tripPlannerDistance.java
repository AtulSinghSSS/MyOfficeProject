package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class tripPlannerDistance implements Serializable {

    @SerializedName("TravelTime")
    private Integer TravelTime;

    @SerializedName("ReminingTime")
    private Integer ReminingTime;
    @SerializedName("DistanceTraveled")
    private Double DistanceTraveled;
    @SerializedName("DistanceLeft")
    private Double DistanceLeft;
    @SerializedName("StartTime")
    private String StartTime;
    @SerializedName("TotalTime")
    private Integer TotalTime;

    public Integer getTravelTime() {
        return TravelTime;
    }

    public void setTravelTime(Integer travelTime) {
        TravelTime = travelTime;
    }

    public Integer getReminingTime() {
        return ReminingTime;
    }

    public void setReminingTime(Integer reminingTime) {
        ReminingTime = reminingTime;
    }

    public Double getDistanceTraveled() {
        return DistanceTraveled;
    }

    public void setDistanceTraveled(Double distanceTraveled) {
        DistanceTraveled = distanceTraveled;
    }

    public Double getDistanceLeft() {
        return DistanceLeft;
    }

    public void setDistanceLeft(Double distanceLeft) {
        DistanceLeft = distanceLeft;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public Integer getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(Integer totalTime) {
        TotalTime = totalTime;
    }
}
