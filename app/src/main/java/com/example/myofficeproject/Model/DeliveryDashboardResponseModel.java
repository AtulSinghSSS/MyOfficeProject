package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DeliveryDashboardResponseModel implements Serializable {

    @SerializedName("Status")
    private String Status;
    @SerializedName("ErrorMessage")
    private String ErrorMessage;
    @SerializedName("Data")
    private DataDeliveryDashbordResponse Data;

    @SerializedName("Timestamp")
    private String Timestamp;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public DataDeliveryDashbordResponse getData() {
        return Data;
    }

    public void setData(DataDeliveryDashbordResponse data) {
        Data = data;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }
}
