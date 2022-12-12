package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataDeliveryDashbordResponse implements Serializable {

    @SerializedName("TripDashboardDC")
    private TripDashboardDC TripDashboardDC;
    @SerializedName("Status")
    private String Status;

    @SerializedName("Message")
    private String Message;

    public TripDashboardDC getTripDashboardDC() {
        return TripDashboardDC;
    }

    public void setTripDashboardDC(com.example.myofficeproject.Model.TripDashboardDC tripDashboardDC) {
        TripDashboardDC = tripDashboardDC;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
