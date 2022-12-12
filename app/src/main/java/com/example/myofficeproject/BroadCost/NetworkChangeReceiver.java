package com.example.myofficeproject.BroadCost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.myofficeproject.Fragment.HomeFragment;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        HomeFragment homeFragment = new HomeFragment();
        try {
            if (isOnline(context)) {
                homeFragment.dialog(true);
                Toast.makeText(context, "Online Connect Intenet", Toast.LENGTH_SHORT).show();
            } else {
                homeFragment.dialog(false);
                Toast.makeText(context, "Conectivity Failure !!!", Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

}


//
//
////        String status =getConnectivityStatusString(context);
////        if(status.isEmpty()) {
////            status="No Internet Connection";
////        }
////        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
//        try
//        {
//
//            String status = null;
//            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//            if (activeNetwork != null) {
//
//                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                    HomeFragment homeFragment=new HomeFragment();
//                    homeFragment.dialog(true);
//                    status = "Wifi enabled";
//
//                    Toast.makeText(context, status, Toast.LENGTH_LONG).show();
//                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                    HomeFragment homeFragment=new HomeFragment();
//                    homeFragment.dialog(true);
//
//                    status = "Mobile data enabled";
//                    //homeFragment.view1(status);
//                    Toast.makeText(context, status, Toast.LENGTH_LONG).show();
//
//
//
////                    LayoutInflater mInflater = LayoutInflater.from(context);
////                    View view = mInflater.inflate(R.layout.fragment_home, null);
////                    view.findViewById(R.id.tv_check_connection).setBackgroundColor(GREEN);
//
//
//                }
//            } else {
//                HomeFragment homeFragment=new HomeFragment();
//                homeFragment.dialog(false);
//                status = "No internet is available";
//                Toast.makeText(context, status, Toast.LENGTH_LONG).show();
//            }
//
//        }catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//      //  Toast.makeText(context, status, Toast.LENGTH_LONG).show();
//
//
////
////        LayoutInflater mInflater = LayoutInflater.from(context);
////        TextView textView = (TextView) mInflater.inflate(R.layout.fragment_home, null);
////        textView.findViewById(R.id.myview);
////        textView.setText(status);
//
//
//
//
//
////        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
////        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
////        if (activeNetwork != null) {
////            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
////                status = "Wifi enabled";
////                //Toast toast = Toast.makeText(context, status, Toast.LENGTH_LONG);toast.show();
////
////
////
////            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
////                status = "Mobile data enabled";
////                Toast toast = Toast.makeText(context, status, Toast.LENGTH_SHORT);
////                toast.setGravity(Gravity.FILL_HORIZONTAL, -800, -800);
////                TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
////                toastMessage.setBackgroundColor(GREEN);
////                toastMessage.setTextColor(WHITE);
////                toastMessage.setTextSize(15);
////                toast.show();
////
////            }
////        } else {
////            status = "No internet is available";
////            //Toast toast = Toast.makeText(context, status, Toast.LENGTH_LONG).show();
////
////
////
////        }
//
//
//
//    public static String getConnectivityStatusString (Context context){
//        String status = null;
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        if (activeNetwork != null) {
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                status = "Wifi enabled";
//                return status;
//            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                status = "Mobile data enabled";
//                return status;
//            }
//        } else {
//            status = "No internet is available";
//            return status;
//        }
//        return status;
//    }
//
//}


//        try
//        {
//            String status=getConnectivityStatusString(context);
//            if(status.isEmpty()) {
//                status="No Internet Connection";
//            }
//           // Toast.makeText(context, status, Toast.LENGTH_LONG).show();
//            Toast toast = Toast.makeText(context, status,Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.FILL_HORIZONTAL, -800, -800);
//                TextView toastMessage=(TextView) toast.getView().findViewById(android.R.id.message);
//                toastMessage.setBackgroundColor(BLACK);
//                toastMessage.setTextColor(WHITE);
//                toastMessage.setTextSize(20);
//                toast.show();
//
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }


//    public static String getConnectivityStatusString(Context context) {
//        String status = null;
//        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        if (activeNetwork != null) {
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                status = "Wifi enabled";
//                return status;
//            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                status = "Mobile data enabled";
//                return status;
//            }
//        } else {
//            status = "No internet is available";
//            return status;
//        }
//        return status;
//    }

