package com.example.myofficeproject.Activity;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_signup);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_signup);
        getSupportActionBar().hide();

      //  SignupClickEvent();

    }

//
//    private void SignupClickEvent(){
//        binding.signupBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (CheckAllFields()) {
//                    // getFragmentManager().beginTransaction().replace(R.id.Container, new SigninFragment()).commit();
//                    Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//    }

//
//    private Boolean  CheckAllFields(){
//
//        String name=binding.nameEDT.getText().toString().trim();
//        String email=binding.emailEDT.getText().toString().trim();
//        String mobile=binding.mobileEDT.getText().toString().trim();
//        String pwd=binding.pwdEDT.getText().toString().trim();
//        String cpwd=binding.cpwdEDT.getText().toString().trim();
//
//        if (name.length()==0){
//            binding.nameEDT.setError("Name is required...!!!");
//            binding.nameEDT.requestFocus();
//            return false;
//        }
//
//        if (email.length()==0){
//            binding.emailEDT.setError("Email is required...!!!");
//            binding.emailEDT.requestFocus();
//            return false;
//        }
//
//        if (mobile.length()==0){
//            binding.mobileEDT.setError("Mobile Number is required...!!!");
//            binding.mobileEDT.requestFocus();
//            return false;
//        }
//
//        if (pwd.length()==0){
//            binding.pwdEDT.setError("Password is required...!!!");
//            binding.pwdEDT.requestFocus();
//            return false;
//        }
//
//        if (cpwd.length()==0){
//            binding.cpwdEDT.setError("Confirm Password is required...!!!");
//            binding.cpwdEDT.requestFocus();
//            return false;
//        }
//
//        if (!(pwd.equals(cpwd))){
//            binding.cpwdEDT.setError("Both Password are not match..!!!");
//            binding.cpwdEDT.requestFocus();
//            return false;
//        }
//        return true;
//    }
}