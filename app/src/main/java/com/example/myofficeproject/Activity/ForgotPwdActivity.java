package com.example.myofficeproject.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.ActivityFoggotPwdBinding;

public class ForgotPwdActivity extends AppCompatActivity {
    ActivityFoggotPwdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_foggot_pwd);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_foggot_pwd);

        getSupportActionBar().hide();
        SignupClickEvent();

    }

    private void SignupClickEvent(){
        binding.showuseridBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (CheckAllFields()) {

                    Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean  CheckAllFields(){


        String email=binding.emailEDT.getText().toString().trim();
        String pwd=binding.pwdEDT.getText().toString().trim();
        String cpwd=binding.cpwdEDT.getText().toString().trim();


        if (email.length()==0){
            binding.emailEDT.setError("Email is required...!!!");
            binding.emailEDT.requestFocus();
            return false;
        }

        if (pwd.length()==0){
            binding.pwdEDT.setError("Password is required...!!!");
            binding.pwdEDT.requestFocus();
            return false;
        }

        if (cpwd.length()==0){
            binding.cpwdEDT.setError("Confirm Password is required...!!!");
            binding.cpwdEDT.requestFocus();
            return false;
        }

        if (!(pwd.equals(cpwd))){
            binding.cpwdEDT.setError("Both Password are not match..!!!");
            binding.cpwdEDT.requestFocus();
            return false;
        }
        return true;
    }
}