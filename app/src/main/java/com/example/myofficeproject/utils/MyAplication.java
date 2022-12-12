package com.example.myofficeproject.utils;

import android.app.Application;
import android.content.Context;

public class MyAplication extends Application {
    private static MyAplication myAplication;


    public static MyAplication getInstance() {
        return myAplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myAplication = this;
    }
}
