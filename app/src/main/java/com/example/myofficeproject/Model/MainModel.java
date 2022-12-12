package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public class MainModel  implements Serializable {

    @SerializedName("Status")
    private String Status;

    @SerializedName("ErrorMessage")
    private String ErrorMessage;

    @SerializedName("Data")
    private Data Data;

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

    public Data getData() {
        return Data;
    }

    public void setData(Data data) {
        Data = data;
    }
}
