package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class People implements Serializable {

    @SerializedName("PeopleID")
    private int PeopleID;
    @SerializedName("CompanyId")
    private int CompanyId;
    @SerializedName("WarehouseId")
    private int WarehouseId;
    @SerializedName("PeopleFirstName")
    private String PeopleFirstName;
    @SerializedName("PeopleLastName")
    private String PeopleLastName;
    @SerializedName("Email")
    private String Email;
    @SerializedName("DisplayName")
    private String DisplayName;
    @SerializedName("Mobile")
    private String Mobile;
    @SerializedName("Password")
    private String Password;
    @SerializedName("VehicleId")
    private int VehicleId;
    @SerializedName("VehicleCapacity")
    private float VehicleCapacity;
    @SerializedName("CreatedDate")
    private String CreatedDate;
    @SerializedName("UpdatedDate")
    private String UpdatedDate;
    @SerializedName("DeviceId")
    private String DeviceId;
    @SerializedName("FcmId")
    private String FcmId;
    @SerializedName("Role")
    private String Role;

    @SerializedName("RegisteredApk")
    private RegisteredApk RegisteredApk;

    public int getPeopleID() {
        return PeopleID;
    }

    public void setPeopleID(int peopleID) {
        PeopleID = peopleID;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public int getWarehouseId() {
        return WarehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        WarehouseId = warehouseId;
    }

    public String getPeopleFirstName() {
        return PeopleFirstName;
    }

    public void setPeopleFirstName(String peopleFirstName) {
        PeopleFirstName = peopleFirstName;
    }

    public String getPeopleLastName() {
        return PeopleLastName;
    }

    public void setPeopleLastName(String peopleLastName) {
        PeopleLastName = peopleLastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public float getVehicleCapacity() {
        return VehicleCapacity;
    }

    public void setVehicleCapacity(float vehicleCapacity) {
        VehicleCapacity = vehicleCapacity;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        UpdatedDate = updatedDate;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getFcmId() {
        return FcmId;
    }

    public void setFcmId(String fcmId) {
        FcmId = fcmId;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public com.example.myofficeproject.Model.RegisteredApk getRegisteredApk() {
        return RegisteredApk;
    }

    public void setRegisteredApk(com.example.myofficeproject.Model.RegisteredApk registeredApk) {
        RegisteredApk = registeredApk;
    }
}
