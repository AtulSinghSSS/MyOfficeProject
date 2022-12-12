package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AcceptResponseData implements Serializable {

    @SerializedName("CheckAssignmentEwayBillAndIRNno")
    private String CheckAssignmentEwayBillAndIRNno;

    @SerializedName("Message")
    private String Message;

    @SerializedName("Status")
    private Boolean Status;

    public String getCheckAssignmentEwayBillAndIRNno() {
        return CheckAssignmentEwayBillAndIRNno;
    }

    public void setCheckAssignmentEwayBillAndIRNno(String checkAssignmentEwayBillAndIRNno) {
        CheckAssignmentEwayBillAndIRNno = checkAssignmentEwayBillAndIRNno;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}
