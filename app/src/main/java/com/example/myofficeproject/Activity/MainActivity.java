package com.example.myofficeproject.Activity;

import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
       //getSupportFragmentManager().beginTransaction().add(R.id.Container,new SigninFragment()).commit();
        getSupportActionBar().hide();
//        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
//        startActivity(intent);

    }
}