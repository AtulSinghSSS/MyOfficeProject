package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class assignmentList implements Serializable {

    @SerializedName("AssignmentId")
    private Integer AssignmentId;

    @SerializedName("NoOfOrder")
    private Integer NoOfOrder;

    @SerializedName("Amount")
    private Double Amount;
    @SerializedName("CreateDate")
    private String CreateDate;
    @SerializedName("AssignmentStatus")
    private String AssignmentStatus;


    public Integer getAssignmentId() {
        return AssignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        AssignmentId = assignmentId;
    }

    public Integer getNoOfOrder() {
        return NoOfOrder;
    }

    public void setNoOfOrder(Integer noOfOrder) {
        NoOfOrder = noOfOrder;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getAssignmentStatus() {
        return AssignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        AssignmentStatus = assignmentStatus;
    }
}
