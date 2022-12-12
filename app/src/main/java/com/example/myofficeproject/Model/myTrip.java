package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class myTrip implements Serializable {

    @SerializedName("CustomerCount")
    private Integer CustomerCount;

    @SerializedName("TotalOrder")
    private Integer TotalOrder;
    @SerializedName("TotalAmount")
    private Double TotalAmount;
    @SerializedName("TripId")
    private Integer TripId;


    public Integer getCustomerCount() {
        return CustomerCount;
    }

    public void setCustomerCount(Integer customerCount) {
        CustomerCount = customerCount;
    }

    public Integer getTotalOrder() {
        return TotalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        TotalOrder = totalOrder;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public Integer getTripId() {
        return TripId;
    }

    public void setTripId(Integer tripId) {
        TripId = tripId;
    }
}
