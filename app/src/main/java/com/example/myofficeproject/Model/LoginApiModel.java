package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginApiModel implements Serializable {

    @SerializedName("Mobile")
    private String Mobile;

    @SerializedName("Password")
    private String Password;

    @SerializedName("DeviceId")
    private String DeviceId;

    @SerializedName("FcmId")
    private String FcmId;

    @SerializedName("CurrentAPKversion")
    private String CurrentAPKversion;

    @SerializedName("PhoneOSversion")
    private String PhoneOSversion;

    @SerializedName("UserDeviceName")
    private String UserDeviceName;

    @SerializedName("IMEI")
    private String IMEI;

    public LoginApiModel(String mobile, String password, String deviceId, String fcmId, String currentAPKversion, String phoneOSversion, String userDeviceName, String IMEI) {
        Mobile = mobile;
        Password = password;
        DeviceId = deviceId;
        FcmId = fcmId;
        CurrentAPKversion = currentAPKversion;
        PhoneOSversion = phoneOSversion;
        UserDeviceName = userDeviceName;
        this.IMEI = IMEI;
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

    public String getCurrentAPKversion() {
        return CurrentAPKversion;
    }

    public void setCurrentAPKversion(String currentAPKversion) {
        CurrentAPKversion = currentAPKversion;
    }

    public String getPhoneOSversion() {
        return PhoneOSversion;
    }

    public void setPhoneOSversion(String phoneOSversion) {
        PhoneOSversion = phoneOSversion;
    }

    public String getUserDeviceName() {
        return UserDeviceName;
    }

    public void setUserDeviceName(String userDeviceName) {
        UserDeviceName = userDeviceName;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
