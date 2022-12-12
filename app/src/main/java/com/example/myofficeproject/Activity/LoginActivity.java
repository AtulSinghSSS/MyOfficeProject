package com.example.myofficeproject.Activity;



import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Typeface;
import android.os.Build;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.myofficeproject.BuildConfig;
import com.example.myofficeproject.Model.DataloginResponse;
import com.example.myofficeproject.Model.LoginApiModel;
import com.example.myofficeproject.Model.LoginResponseModel;
import com.example.myofficeproject.Model.TokenModel;
import com.example.myofficeproject.R;
import com.example.myofficeproject.Remote.ApiClient;
import com.example.myofficeproject.Remote.ApiInterface;
import com.example.myofficeproject.databinding.ActivityLoginBinding;
import com.example.myofficeproject.utils.ConstentClass;
import com.example.myofficeproject.utils.MyAplication;
import com.example.myofficeproject.utils.SharePrefs;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.provider.Settings.Secure;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    String url;
    String imei;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_signin);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        SigninClickevent();
        // callingApiSignin();

        //SignupClickEvent();
        //ForgotUseridEvent();
        //ForgotPwdEvent();
    }

    private void SigninClickevent() {


        binding.LoginBTN.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                String Mobile=binding.mobileEDT.getText().toString();
                String Password=binding.passwordEDT.getText().toString();
                String DeviceId = Secure.getString(getApplicationContext().getContentResolver(),Secure.ANDROID_ID);
                String CurrentAPKversion= BuildConfig.VERSION_NAME;
                String PhoneOSversion = android.os.Build.VERSION.RELEASE;
                String UserDeviceName  = android.os.Build.MODEL;

//                int REQUEST_CODE = 101;
//                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//                if (Build.VERSION.SDK_INT >= 26) {
//                    imei = telephonyManager.getImei();
//                }else {
//                    imei = telephonyManager.getDeviceId();
//                }


                if (ChackValidation()) {

                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    Call<JsonElement> call = apiService.getLoginApi(new LoginApiModel(Mobile,Password,DeviceId,"",CurrentAPKversion,PhoneOSversion,UserDeviceName,"imei"));

                    Log.e("Request===> ", new Gson().toJson(new LoginApiModel(Mobile,Password,DeviceId,"",CurrentAPKversion,PhoneOSversion,UserDeviceName,"imei")));

                    call.enqueue(new Callback<JsonElement>() {
                        @Override
                        public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                            Log.e("Responce====> ", new Gson().toJson(response.body()));
                            LoginResponseModel loginResponseModel = new Gson().fromJson(response.body(), new TypeToken<LoginResponseModel>() {}.getType());

                            if (response.body()!=null) {

                                SharePrefs.getInstance(LoginActivity.this).putInt(SharePrefs.PEPOLE_ID, loginResponseModel.getData().getPeople().getPeopleID());
                                SharePrefs.getInstance(LoginActivity.this).putInt(SharePrefs.COMPANY_ID, loginResponseModel.getData().getPeople().getCompanyId());
                                SharePrefs.getInstance(LoginActivity.this).putInt(SharePrefs.WAREHOUSE_ID, loginResponseModel.getData().getPeople().getWarehouseId());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.PEOPLE_FRIST_NAME, loginResponseModel.getData().getPeople().getPeopleFirstName());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.PEOPLE_LAST_NAME, loginResponseModel.getData().getPeople().getPeopleLastName());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.EMAIL, loginResponseModel.getData().getPeople().getEmail());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.DISPLAY_NAME, loginResponseModel.getData().getPeople().getDisplayName());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.MOBILE_NUMBER,loginResponseModel.getData().getPeople().getMobile());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.PASSWORD,loginResponseModel.getData().getPeople().getPassword());
                                SharePrefs.getInstance(LoginActivity.this).putInt(SharePrefs.VEHICLE_ID,loginResponseModel.getData().getPeople().getVehicleId());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.CREATED_DATE,loginResponseModel.getData().getPeople().getCreatedDate());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.UPDATED_DATE,loginResponseModel.getData().getPeople().getUpdatedDate());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.ROLE,loginResponseModel.getData().getPeople().getRole());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.USER_NAME,loginResponseModel.getData().getPeople().getRegisteredApk().getUserName());
                                SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.PASSWORD,loginResponseModel.getData().getPeople().getRegisteredApk().getPassword());
                                SharePrefs.getInstance(LoginActivity.this).putBoolean(SharePrefs.IS_LOGIN,true);
                                Log.e("TAG", "MOBILE_NUMBER: "+ SharePrefs.getInstance(MyAplication.getInstance()).getString(SharePrefs.MOBILE_NUMBER));


                                getTokenApi(loginResponseModel.getData().getPeople().getRegisteredApk().getUserName(),loginResponseModel.getData().getPeople().getRegisteredApk().getPassword());

                            }
                        }

                        @Override
                        public void onFailure(Call<JsonElement> call, Throwable t) {
                            Log.d("TAG", "Response = " + t.toString());
                        }
                    });
                }
            }
        });
    }


    private void getTokenApi(String userName, String password) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonElement> call = apiService.getToken("password",userName,password);

        call.enqueue(new Callback<JsonElement>(){
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.e("ResponceToken=====> ", new Gson().toJson(response.body()));

                TokenModel tokenModel = new Gson().fromJson(response.body(), new TypeToken<TokenModel>() {}.getType());

                if (tokenModel!= null) {

                    SharePrefs.getInstance(LoginActivity.this).putString(SharePrefs.SAVE_TOKEN, tokenModel.getAccess_token());
                    Log.e("TAG", "SAVE_TOKEN: "+ SharePrefs.getInstance(MyAplication.getInstance()).getString(SharePrefs.SAVE_TOKEN));
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }


    private Boolean ChackValidation() {
        String mobile = binding.mobileEDT.getText().toString().trim();
        String pwd = binding.passwordEDT.getText().toString().trim();

        if (mobile.length() <= 0) {
            binding.mobileEDT.setError("Mobile required..!!");
            binding.mobileEDT.requestFocus();
            return false;
        }

        if (mobile.length()!= 10) {
            binding.mobileEDT.setError("10 digit required..!!");
            binding.mobileEDT.requestFocus();
            return false;
        }

        if (pwd.length() <= 0) {
            binding.passwordEDT.setError("Password required..!!");
            binding.passwordEDT.requestFocus();
            return false;
        }

        if (pwd.length() >=10) {
            binding.passwordEDT.setError("10 character required..!!");
            binding.passwordEDT.requestFocus();
            return false;
        }
        return true;


    }

}














//    private void callingApiSignin() {
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<JsonElement> call = apiService.getSigninApi(new SigninApiModel("Mobile","Password","DeviceId","","CurrentAPKversion","PhoneOSversion","UserDeviceName","IMEI"));
//
//
//        call.enqueue(new Callback<JsonElement>(){
//            @Override
//            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
//
//                SigninApiModel signinApiModel =new Gson().fromJson(response.body(),new TypeToken<SigninApiModel>(){}.getType());
//                Log.e("ResponceSigninApi===> ", new Gson().toJson(response.body()));
//
//                if (signinApiModel!=null){
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonElement> call, Throwable t) {
//                Log.d("TAG","Response = "+t.toString());
//            }
//        });
//    }






//    private void SignupClickEvent() {
//
//        binding.signupTV.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

//    private void ForgotUseridEvent() {
//
//        binding.useridTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // getFragmentManager().beginTransaction().replace(R.id.Container,new ForgotUseridFragment()).addToBackStack( "tag" ).commit();
//                Intent intent = new Intent(LoginActivity.this, ForgotUseridActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

//    private void ForgotPwdEvent() {
//
//        binding.passwordTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //getFragmentManager().beginTransaction().replace(R.id.Container,new ForgotPwdFragment()).addToBackStack( "tag" ).commit();
//                Intent intent = new Intent(LoginActivity.this, ForgotPwdActivity.class);
//                startActivity(intent);
//
//            }
//        });
//    }

//    private Boolean ChackValidation() {
//        String userid = binding.useridEDT.getText().toString().trim();
//        String pwd = binding.passwordEDT.getText().toString().trim();
//
//        if (userid.length() <= 0) {
//            binding.useridEDT.setError("UserId required..!!");
//            binding.useridEDT.requestFocus();
//            return false;
//        }
//
//        if (pwd.length() <= 0) {
//            binding.passwordEDT.setError("Password required..!!");
//            binding.passwordEDT.requestFocus();
//            return false;
//        }
//
//        if (pwd.length() >= 8) {
//            binding.passwordEDT.setError("8 character required..!!");
//            binding.passwordEDT.requestFocus();
//            return false;
//        }
//        return true;
//    }



//}
