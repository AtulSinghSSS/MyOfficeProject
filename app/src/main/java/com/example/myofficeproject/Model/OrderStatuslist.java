package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderStatuslist implements Serializable {

    @SerializedName("TotalShippedOrder")
    private Integer TotalShippedOrder;

    @SerializedName("TotalShippedAmount")
    private Double TotalShippedAmount;
    @SerializedName("TotalDeliveredOrder")
    private Integer TotalDeliveredOrder;
    @SerializedName("TotalDeliveredAmount")
    private Double TotalDeliveredAmount;
    @SerializedName("TotalDeliveryCanceledOrder")
    private Integer TotalDeliveryCanceledOrder;
    @SerializedName("TotalDeliveryCanceledAmount")
    private Double TotalDeliveryCanceledAmount;
    @SerializedName("TotalDeliveryRedispatchOrder")
    private Integer TotalDeliveryRedispatchOrder;
    @SerializedName("TotalDeliveryRedispatchAmount")
    private Double TotalDeliveryRedispatchAmount;
    @SerializedName("TotalReAttemptOrder")
    private Integer TotalReAttemptOrder;
    @SerializedName("TotalReAttemptAmount")
    private Double TotalReAttemptAmount;


    public Integer getTotalShippedOrder() {
        return TotalShippedOrder;
    }

    public void setTotalShippedOrder(Integer totalShippedOrder) {
        TotalShippedOrder = totalShippedOrder;
    }

    public Double getTotalShippedAmount() {
        return TotalShippedAmount;
    }

    public void setTotalShippedAmount(Double totalShippedAmount) {
        TotalShippedAmount = totalShippedAmount;
    }

    public Integer getTotalDeliveredOrder() {
        return TotalDeliveredOrder;
    }

    public void setTotalDeliveredOrder(Integer totalDeliveredOrder) {
        TotalDeliveredOrder = totalDeliveredOrder;
    }

    public Double getTotalDeliveredAmount() {
        return TotalDeliveredAmount;
    }

    public void setTotalDeliveredAmount(Double totalDeliveredAmount) {
        TotalDeliveredAmount = totalDeliveredAmount;
    }

    public Integer getTotalDeliveryCanceledOrder() {
        return TotalDeliveryCanceledOrder;
    }

    public void setTotalDeliveryCanceledOrder(Integer totalDeliveryCanceledOrder) {
        TotalDeliveryCanceledOrder = totalDeliveryCanceledOrder;
    }

    public Double getTotalDeliveryCanceledAmount() {
        return TotalDeliveryCanceledAmount;
    }

    public void setTotalDeliveryCanceledAmount(Double totalDeliveryCanceledAmount) {
        TotalDeliveryCanceledAmount = totalDeliveryCanceledAmount;
    }

    public Integer getTotalDeliveryRedispatchOrder() {
        return TotalDeliveryRedispatchOrder;
    }

    public void setTotalDeliveryRedispatchOrder(Integer totalDeliveryRedispatchOrder) {
        TotalDeliveryRedispatchOrder = totalDeliveryRedispatchOrder;
    }

    public Double getTotalDeliveryRedispatchAmount() {
        return TotalDeliveryRedispatchAmount;
    }

    public void setTotalDeliveryRedispatchAmount(Double totalDeliveryRedispatchAmount) {
        TotalDeliveryRedispatchAmount = totalDeliveryRedispatchAmount;
    }

    public Integer getTotalReAttemptOrder() {
        return TotalReAttemptOrder;
    }

    public void setTotalReAttemptOrder(Integer totalReAttemptOrder) {
        TotalReAttemptOrder = totalReAttemptOrder;
    }

    public Double getTotalReAttemptAmount() {
        return TotalReAttemptAmount;
    }

    public void setTotalReAttemptAmount(Double totalReAttemptAmount) {
        TotalReAttemptAmount = totalReAttemptAmount;
    }
}
