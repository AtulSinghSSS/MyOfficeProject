package com.example.myofficeproject.Remote;

import android.util.Log;

import com.example.myofficeproject.utils.MyAplication;
import com.example.myofficeproject.utils.SharePrefs;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String BASE_URL = "https://uat.shopkirana.in/";
    private static Retrofit retrofit;


    public static Retrofit getClient() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("authorization", "Bearer " + SharePrefs.getInstance(MyAplication.getInstance()).getString(SharePrefs.SAVE_TOKEN))
                        .addHeader("username", SharePrefs.getInstance(MyAplication.getInstance()).getString(SharePrefs.MOBILE_NUMBER))
                        .build();
                Log.e("intercept", "SAVE_TOKEN: "+ SharePrefs.getInstance(MyAplication.getInstance()).getString(SharePrefs.SAVE_TOKEN));
                return chain.proceed(request);
            }
        });
        httpClient.addInterceptor(interceptor);

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
            }

        return retrofit;
    }

}
