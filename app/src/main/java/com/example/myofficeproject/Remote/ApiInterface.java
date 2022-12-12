package com.example.myofficeproject.Remote;
import com.example.myofficeproject.Model.AcceptAPiModel;
import com.example.myofficeproject.Model.LoginApiModel;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Noencryption: 1")
    @GET("/api/RetailerApp/GetCompanyDetailsForRetailer")
    Call<JsonElement>getData();

    @Headers("Noencryption: 1")
    @GET("/api/appVersion/NewDeliveryApp")
    Call<JsonElement>getVersionApi();

    @Headers("Noencryption: 1")
    @POST("/api/DBSignup/NewDeliveryV2")
    Call<JsonElement>getLoginApi(@Body LoginApiModel LoginApiModel);

    @Headers("Noencryption: 1")
    @GET("api/DeliveryApp/DeliveryDashboard")
    Call<JsonElement>getDeliveryDashboard(@Query("PeopleId") Integer pepleID);


    @Headers("Noencryption: 1")
    @FormUrlEncoded
    @POST("/token")
    Call<JsonElement>getToken(@Field("grant_type") String grant_type,
                              @Field("username") String username,
                              @Field("password") String password);

    @Headers("Noencryption: 1")
    @PUT("api/DeliveryIssuance/AssignmentAcceptNew")
    Call<JsonElement>getAcceptAPi(@Body AcceptAPiModel acceptAPiModel);

}
