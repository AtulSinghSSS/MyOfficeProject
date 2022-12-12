package com.example.myofficeproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by User on 13-11-2018.
 */

public class SharePrefs {
    public static String SHARED_PREF_NAME = "fcmsharedprefname";
    public static String KEY_ACCESS_TOKEN = "token";
    public static String MOBILE_NUMBER = "mobile";
    public static String IS_VERIFIED = "IsVerified";
    public static String SUPPLIER_ID = "Customer_Id";
    public static String SUPPLIER_CATEGORY_ID = "SUPPLIER_CATEGORY_ID";
    public static String SUPPLIER_NAME = "Name";
    public static String SUPPLIER_IMAGE = "image";
    public static String IS_ACTIVE = "is_active";
    public static String SHOP_NAME = "shop_name";
    public static String COMPANY_ID = "company_id";
    public static String WAREHOUSE_ID = "warehouse_id";
    public static String FCM_TOKEN = "FCM_TOKEN";
    public static String PREFERENCE = "SkRetailer";
    public static String TOKEN = "empty_token";
    public static String PEPOLE_ID = "peple_id";
    public static String TOKEN_NAME = "TokenName";
    public static String TOKEN_PASSWORD = "Token_password";
    public static String DEPO_ID = "depo_id";
    public static String IMAGE_PATH = "image_path";
    public static String HOME_ITEMS = "HOME_ITEMS";
    public static String CUSTOMERSUPPORT = "CUSTOMER_SUPPORT";
    public static String WEREHOUSE_ID = "warehouseId";
    public static String PEOPLE_FRIST_NAME = "peopleFirstName";
    public static String PEOPLE_LAST_NAME = "peopleLastName";
    public static String EMAIL = "email";
    public static String DISPLAY_NAME = "displayName";
    public static String VEHICLE_ID = "vehicleId";
    public static String VEHICLE_CAPACITY = "vehicle_Capacity";
    public static String CREATED_DATE = "created_date";
    public static String UPDATED_DATE = "updated_date";
    public static String ROLE = "role";
    public static String USER_NAME = "user_name";
    public static String PASSWORD = "password";
    public static String LOGD_BODY_LOCATION_METER = "LogDboy_LoctionMeter";
    public static String IS_LOGIN = "isLogin";
    public static String SAVE_TOKEN = "token";

    Context ctx;
    SharedPreferences sharedPreferences;
    static SharePrefs instance;

    public SharePrefs(Context context) {
        ctx = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharePrefs getInstance(Context ctx) {
        if (instance == null) {
            instance = new SharePrefs(ctx);
        }
        return instance;
    }

    public void putString(String key, String val) {
        sharedPreferences.edit().putString(key, val).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void putInt(String key, Integer val) {
        sharedPreferences.edit().putInt(key, val).apply();
    }

    public void putBoolean(String key, Boolean val) {
        sharedPreferences.edit().putBoolean(key, val).apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void clearSharePrefs() {
        sharedPreferences.edit().clear().commit();
    }


    public static String getStringSharedPreferences(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        return settings.getString(name, "");
    }

    // for username string preferences
    public static void setStringSharedPreference(Context context, String name, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(name, value);
        editor.apply();
    }

    public boolean storeToken(String Token) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN, Token);
        editor.apply();
        return true;
    }

    public String getToken() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null);
    }
}
