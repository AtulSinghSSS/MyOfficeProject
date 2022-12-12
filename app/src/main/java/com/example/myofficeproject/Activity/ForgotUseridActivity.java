package com.example.myofficeproject.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.ActivityForgotUseridBinding;

public class ForgotUseridActivity extends AppCompatActivity {
ActivityForgotUseridBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_forgot_userid);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_forgot_userid);

        getSupportActionBar().hide();

        clickEvent();
    }




    private void clickEvent(){

        binding.showuseridBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (CheckAllFields()){
                    Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private Boolean CheckAllFields(){

        String email=binding.emailEDT.getText().toString().trim();

        if (email.length()==0){
            binding.emailEDT.setError("Email is required...!!!");
            binding.emailEDT.requestFocus();
            return false;
        }
        return true;
    }
}