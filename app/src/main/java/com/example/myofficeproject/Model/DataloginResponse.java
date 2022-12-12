package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataloginResponse implements Serializable {

    @SerializedName("P")
    private People People;

    @SerializedName("Status")
    private Boolean Status;
    @SerializedName("Message")
    private String Message;

    public People getPeople() {
        return People;
    }

    public void setPeople(People people) {
        People = people;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
