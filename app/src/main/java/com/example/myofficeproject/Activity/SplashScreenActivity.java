package com.example.myofficeproject.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.BuildConfig;
import com.example.myofficeproject.Model.MainModel;
import com.example.myofficeproject.Model.VersionApiModel;
import com.example.myofficeproject.R;
import com.example.myofficeproject.Remote.ApiClient;
import com.example.myofficeproject.Remote.ApiInterface;
import com.example.myofficeproject.Remote.Common;
import com.example.myofficeproject.databinding.ActivitySplashScreenBinding;
import com.example.myofficeproject.utils.SharePrefs;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    String currentVersionName;
    AlertDialog alertDialog;
    MainModel mainModel;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);
        //sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);



        currentVersionName = BuildConfig.VERSION_NAME;

        getSupportActionBar().hide();
        checkInternetConnectivity();

    }





        private void checkInternetConnectivity() {

            if (Common.checkConnection(getApplicationContext())) {

                callingApi();

            } else {
                Toast.makeText(this, "No Internet connect", Toast.LENGTH_SHORT).show();
            }
        }


    private void splashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Boolean isLogin = SharePrefs.getInstance(getApplicationContext()).getBoolean(SharePrefs.IS_LOGIN);
                if (isLogin) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 10);
    }


    public void allertdilog() {
        alertDialog = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)

                .setTitle("Are you sure to update ?")
                .setMessage("current Version Is " + currentVersionName)
                .setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        playstore();
                        finish();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what should happen when negative button is clicked
                        Toast.makeText(getApplicationContext(), "Nothing Happened", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .show();
    }


    private void playstore() {
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    private void callingApi() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonElement> call = apiService.getData();
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                mainModel = new Gson().fromJson(response.body(), new TypeToken<MainModel>() {
                }.getType());
                Log.e("Responce=> ", new Gson().toJson(response.body()));

                if (mainModel != null) {
                    //SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    SharePrefs.getInstance(SplashScreenActivity.this).putInt(SharePrefs.LOGD_BODY_LOCATION_METER, mainModel.getData().getCompanyDetails().getLogDboyLoctionMeter());

//                    myEdit.putInt("LogDboyLoctionMeter", mainModel.getData().getCompanyDetails().getLogDboyLoctionMeter());
//                    myEdit.apply();

                    callversionApi1();

                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("TAG", "Response = " + t);
            }
        });
    }

    private void callversionApi1() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonElement> call = apiService.getVersionApi();
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                ArrayList<VersionApiModel> versionApiModel = new Gson().fromJson(String.valueOf(response.body()), new TypeToken<ArrayList<VersionApiModel>>() {
                }.getType());
                if (versionApiModel != null && versionApiModel.size() > 0) {
                    for (int i = 0; i < versionApiModel.size(); i++) {
                        if (currentVersionName.equals(versionApiModel.get(i).getApp_version())) {

                            splashScreen();
                        } else {
                            allertdilog();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("TAG", "Response = " + t);
            }
        });
    }
}
