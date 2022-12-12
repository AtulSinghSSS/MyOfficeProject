package com.example.myofficeproject.Activity;

import android.content.Intent;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;


import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myofficeproject.BroadCost.AirPlaneMode;
import com.example.myofficeproject.BroadCost.NetworkChangeReceiver;
import com.example.myofficeproject.Fragment.ContactFragment;
import com.example.myofficeproject.Fragment.HomeFragment;
import com.example.myofficeproject.Fragment.ServicesFragment;
import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.ActivityHomeBinding;
import com.example.myofficeproject.utils.SharePrefs;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    ActionBarDrawerToggle actionBarDrawerToggle;

//    NetworkChangeReceiver mNetworkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.myDrawerLayout, R.string.nav_open, R.string.nav_close);
        binding.myDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        home();
        navigationClickItem();

//        mNetworkReceiver = new NetworkChangeReceiver();
//        registerNetworkBroadcastForNougat();







    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void navigationClickItem(){
        binding.navigationview1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        binding.myDrawerLayout.closeDrawers();
                        home();
                        break;
                    case R.id.contact:
                        binding.myDrawerLayout.closeDrawers();
                        contact();

                        break;
                    case R.id.service:
                        binding.myDrawerLayout.closeDrawers();
                        service();
                        break;

                    case R.id.LogOut:
                        binding.myDrawerLayout.closeDrawers();
                        Logout();
                        break;
                }

                return true;
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(chackWiFi, intentFilter);
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        unregisterReceiver(chackWiFi);
//    }
//





    AirPlaneMode airplaneModeChangeReceiver = new AirPlaneMode();

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChangeReceiver);

    }



//    public  void dialog(boolean value){
//
//        if(value){
////            binding.tvCheckConnection.setText("We are back !!!");
////            binding.tvCheckConnection.setBackgroundColor(Color.GREEN);
////            binding.tvCheckConnection.setTextColor(Color.WHITE);
//
//            Handler handler = new Handler();
//            Runnable delayrunnable = new Runnable() {
//                @Override
//                public void run() {
////                    binding.tvCheckConnection.setVisibility(View.GONE);
//                }
//            };
//            handler.postDelayed(delayrunnable, 3000);
//        }else {
////            binding.tvCheckConnection.setVisibility(View.VISIBLE);
////            binding.tvCheckConnection.setText("Could not Connect to internet");
////            binding.tvCheckConnection.setBackgroundColor(Color.RED);
////            binding.tvCheckConnection.setTextColor(Color.WHITE);
//        }
//    }


//    private void registerNetworkBroadcastForNougat() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//        }
//    }
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(mNetworkReceiver);
//    }


    private void home() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();


    }
    private void contact() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ContactFragment()).commit();

    }
    private void service() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ServicesFragment()).commit();

    }

    private void Logout() {
        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
        SharePrefs.getInstance(getApplicationContext()).clearSharePrefs();
        finish();
        startActivity(intent);

    }
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_home, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    
}

