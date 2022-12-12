package com.example.myofficeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data  implements Serializable {

    @SerializedName("CompanyDetails")
    private CompanyDetails CompanyDetails;

    public CompanyDetails getCompanyDetails() {
        return CompanyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        CompanyDetails = companyDetails;
    }
}
