package com.example.myofficeproject.Activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.Adapter.ViewPagerAdapter;
import com.example.myofficeproject.Fragment.ListViewFragment;
import com.example.myofficeproject.Fragment.MapFragment1;
import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.ActivityStartTripBinding;

public class StartTripActivity extends AppCompatActivity {
    ActivityStartTripBinding binding;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start_trip);



        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new MapFragment1(), "MAP");
        viewPagerAdapter.add(new ListViewFragment(), "LIST VIEW");


        // Set the adapter
       binding.viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().

        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }
}