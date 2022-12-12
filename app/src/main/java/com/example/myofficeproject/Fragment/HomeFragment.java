package com.example.myofficeproject.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.myofficeproject.Activity.StartTripActivity;
import com.example.myofficeproject.Adapter.DasbordAdapter;
import com.example.myofficeproject.Model.DeliveryDashboardResponseModel;
import com.example.myofficeproject.Model.assignmentList;
import com.example.myofficeproject.R;
import com.example.myofficeproject.Remote.ApiClient;
import com.example.myofficeproject.Remote.ApiInterface;
import com.example.myofficeproject.databinding.FragmentHomeBinding;
import com.example.myofficeproject.utils.SharePrefs;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    private ArrayList<assignmentList> assignmentLists;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View view = binding.getRoot();

        int peopelid = SharePrefs.getInstance(getContext()).getInt(SharePrefs.PEPOLE_ID);
        Log.e("peopelid", "onCreateView: " + peopelid);


        binding.ivViewAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.rvTripOrderStatus.getVisibility() == View.VISIBLE) {
                    binding.ivViewAssignment.setImageResource(R.drawable.ic_baseline_expand_less_24);
                    binding.rvTripOrderStatus.setVisibility(View.GONE);
                } else {
                    binding.ivViewAssignment.setImageResource(R.drawable.ic_baseline_expand_more_24);
                    binding.rvTripOrderStatus.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.cdvStartTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), StartTripActivity.class);
                startActivity(intent);
            }
        });

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonElement> call = apiService.getDeliveryDashboard(peopelid);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.e("Responce=====> ", new Gson().toJson(response.body()));

                DeliveryDashboardResponseModel dasbordmodel = new Gson().fromJson(response.body(), new TypeToken<DeliveryDashboardResponseModel>() {
                }.getType());


                if (dasbordmodel != null) {

                    binding.TravelTimeTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getTripPlannerDistance().getTravelTime()));
                    binding.ProgressCircularId1.setProgress(dasbordmodel.getData().getTripDashboardDC().getTripPlannerDistance().getTravelTime());
                    binding.RemeningTimeTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getTripPlannerDistance().getReminingTime()));
                    binding.ProgressCircularId2.setProgress(dasbordmodel.getData().getTripDashboardDC().getTripPlannerDistance().getReminingTime());
                    binding.DistanceTravelTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getTripPlannerDistance().getDistanceTraveled()));
                    binding.DistanceLeftTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getTripPlannerDistance().getDistanceLeft()));
                    binding.TripIDTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getMyTrip().getTripId()));
                    binding.TotalCustomerTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getMyTrip().getCustomerCount()));
                    binding.TotalOrderTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getMyTrip().getTotalOrder()));
                    binding.TotalAmountTV.setText(String.valueOf("₹ " + dasbordmodel.getData().getTripDashboardDC().getMyTrip().getTotalAmount()));


                    binding.TotalShippedOrderTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalShippedOrder()));
                    binding.TotalShippedAmountTV.setText(String.valueOf("₹ " + dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalShippedAmount()));
                    binding.TotalDeliveredOrderTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalDeliveredOrder()));
                    binding.TotalDeliveredAmountTV.setText(String.valueOf("₹ " + dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalDeliveredAmount()));
                    binding.TotalDeliveryCanceledOrderTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalDeliveryCanceledOrder()));
                    binding.TotalDeliveryCanceledAmountTV.setText(String.valueOf("₹ " + dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalDeliveryCanceledAmount()));
                    binding.TotalDeliveryRedispatchOrderTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalDeliveryRedispatchOrder()));
                    binding.TotalDeliveryRedispatchAmountTV.setText(String.valueOf("₹ " + dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalDeliveryRedispatchOrder()));
                    binding.TotalReAttemptOrderTV.setText(String.valueOf(dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalReAttemptOrder()));
                    binding.TotalReAttemptAmountTV.setText(String.valueOf("₹ " + dasbordmodel.getData().getTripDashboardDC().getOrderStatuslist().getTotalReAttemptAmount()));


                    assignmentLists = dasbordmodel.getData().getTripDashboardDC().getAssignmentList();
                    DasbordAdapter dasbordAdapter = new DasbordAdapter(getContext(), assignmentLists);
                    binding.rvTripOrderStatus.setAdapter(dasbordAdapter);

                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(mMessageReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(mMessageReceiver);
        //getActivity().sendBroadcast(new Intent("wallet"));
    }


    public void dialog(boolean value) {
        if (value) {
            binding.tvCheckConnection.setText("We are back !!!");
            binding.tvCheckConnection.setBackgroundColor(Color.GREEN);
            binding.tvCheckConnection.setTextColor(Color.WHITE);

            Handler handler = new Handler();
            Runnable delayrunnable = new Runnable() {
                @Override
                public void run() {
                    binding.tvCheckConnection.setVisibility(View.GONE);
                }
            };
            handler.postDelayed(delayrunnable, 3000);
        } else {
            binding.tvCheckConnection.setVisibility(View.VISIBLE);
            binding.tvCheckConnection.setText("Could not Connect to internet");
            binding.tvCheckConnection.setBackgroundColor(Color.RED);
            binding.tvCheckConnection.setTextColor(Color.WHITE);
        }
    }



    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                dialog(true);
            } else {
                dialog(false);
            }
        }
    };
}














