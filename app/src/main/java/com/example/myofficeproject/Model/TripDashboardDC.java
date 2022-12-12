package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class TripDashboardDC implements Serializable {

    @SerializedName("TripPlannerConfirmedMasterId")
    private Integer TripPlannerConfirmedMasterId;

    @SerializedName("CurrentStatus")
    private Integer CurrentStatus;
    @SerializedName("IsTripEnd")
    private Boolean IsTripEnd;
    @SerializedName("TripPlannerVehicleId")
    private Integer TripPlannerVehicleId;
    @SerializedName("TripPlannerConfirmedDetailId")
    private Integer TripPlannerConfirmedDetailId;
    @SerializedName("BreakTimeInSec")
    private Integer BreakTimeInSec;
    @SerializedName("StartKm")
    private Double StartKm;

    @SerializedName("tripPlannerDistance")
    private tripPlannerDistance tripPlannerDistance;

    @SerializedName("myTrip")
    private myTrip myTrip;

    @SerializedName("assignmentList")
    private ArrayList<assignmentList> assignmentList;

    @SerializedName("OrderStatuslist")
    private OrderStatuslist OrderStatuslist;

    @SerializedName("CustomerTripStatus")
    private Integer CustomerTripStatus;
    @SerializedName("CustomerId")
    private Integer CustomerId;

    @SerializedName("ApproveNotifyTimeLeftInMinute")
    private Integer ApproveNotifyTimeLeftInMinute;
    @SerializedName("TripWorkingStatus")
    private Integer TripWorkingStatus;
    @SerializedName("IsNotLastMileTrip")
    private Boolean IsNotLastMileTrip;


    public Integer getTripPlannerConfirmedMasterId() {
        return TripPlannerConfirmedMasterId;
    }

    public void setTripPlannerConfirmedMasterId(Integer tripPlannerConfirmedMasterId) {
        TripPlannerConfirmedMasterId = tripPlannerConfirmedMasterId;
    }

    public Integer getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        CurrentStatus = currentStatus;
    }

    public Boolean getTripEnd() {
        return IsTripEnd;
    }

    public void setTripEnd(Boolean tripEnd) {
        IsTripEnd = tripEnd;
    }

    public Integer getTripPlannerVehicleId() {
        return TripPlannerVehicleId;
    }

    public void setTripPlannerVehicleId(Integer tripPlannerVehicleId) {
        TripPlannerVehicleId = tripPlannerVehicleId;
    }

    public Integer getTripPlannerConfirmedDetailId() {
        return TripPlannerConfirmedDetailId;
    }

    public void setTripPlannerConfirmedDetailId(Integer tripPlannerConfirmedDetailId) {
        TripPlannerConfirmedDetailId = tripPlannerConfirmedDetailId;
    }

    public Integer getBreakTimeInSec() {
        return BreakTimeInSec;
    }

    public void setBreakTimeInSec(Integer breakTimeInSec) {
        BreakTimeInSec = breakTimeInSec;
    }

    public Double getStartKm() {
        return StartKm;
    }

    public void setStartKm(Double startKm) {
        StartKm = startKm;
    }

    public com.example.myofficeproject.Model.tripPlannerDistance getTripPlannerDistance() {
        return tripPlannerDistance;
    }

    public void setTripPlannerDistance(com.example.myofficeproject.Model.tripPlannerDistance tripPlannerDistance) {
        this.tripPlannerDistance = tripPlannerDistance;
    }

    public com.example.myofficeproject.Model.myTrip getMyTrip() {
        return myTrip;
    }

    public void setMyTrip(com.example.myofficeproject.Model.myTrip myTrip) {
        this.myTrip = myTrip;
    }

    public ArrayList<com.example.myofficeproject.Model.assignmentList> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(ArrayList<com.example.myofficeproject.Model.assignmentList> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public com.example.myofficeproject.Model.OrderStatuslist getOrderStatuslist() {
        return OrderStatuslist;
    }

    public void setOrderStatuslist(com.example.myofficeproject.Model.OrderStatuslist orderStatuslist) {
        OrderStatuslist = orderStatuslist;
    }

    public Integer getCustomerTripStatus() {
        return CustomerTripStatus;
    }

    public void setCustomerTripStatus(Integer customerTripStatus) {
        CustomerTripStatus = customerTripStatus;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public Integer getApproveNotifyTimeLeftInMinute() {
        return ApproveNotifyTimeLeftInMinute;
    }

    public void setApproveNotifyTimeLeftInMinute(Integer approveNotifyTimeLeftInMinute) {
        ApproveNotifyTimeLeftInMinute = approveNotifyTimeLeftInMinute;
    }

    public Integer getTripWorkingStatus() {
        return TripWorkingStatus;
    }

    public void setTripWorkingStatus(Integer tripWorkingStatus) {
        TripWorkingStatus = tripWorkingStatus;
    }

    public Boolean getNotLastMileTrip() {
        return IsNotLastMileTrip;
    }

    public void setNotLastMileTrip(Boolean notLastMileTrip) {
        IsNotLastMileTrip = notLastMileTrip;
    }
}
