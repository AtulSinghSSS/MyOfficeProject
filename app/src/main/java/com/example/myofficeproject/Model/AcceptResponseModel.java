package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AcceptResponseModel implements Serializable {

    @SerializedName("Status")
    private String Status;

    @SerializedName("ErrorMessage")
    private String ErrorMessage;

    @SerializedName("Data")
    private AcceptResponseData Data;

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

    public AcceptResponseData getData() {
        return Data;
    }

    public void setData(AcceptResponseData data) {
        Data = data;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }
}
