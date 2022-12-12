package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AcceptAPiModel implements Serializable {

    @SerializedName("DeliveryIssuanceId")
    private int DeliveryIssuanceId;

    @SerializedName("Acceptance")
    private String Acceptance;

    @SerializedName("RejectReason")
    private String RejectReason;

    public AcceptAPiModel(int deliveryIssuanceId, String acceptance, String rejectReason) {
        DeliveryIssuanceId = deliveryIssuanceId;
        Acceptance = acceptance;
        RejectReason = rejectReason;


    }

    public int getDeliveryIssuanceId() {
        return DeliveryIssuanceId;
    }

    public void setDeliveryIssuanceId(int deliveryIssuanceId) {
        DeliveryIssuanceId = deliveryIssuanceId;
    }

    public String getAcceptance() {
        return Acceptance;
    }

    public void setAcceptance(String acceptance) {
        Acceptance = acceptance;
    }

    public String getRejectReason() {
        return RejectReason;
    }

    public void setRejectReason(String rejectReason) {
        RejectReason = rejectReason;
    }
}
