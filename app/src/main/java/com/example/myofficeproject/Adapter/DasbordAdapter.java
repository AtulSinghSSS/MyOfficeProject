package com.example.myofficeproject.Adapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myofficeproject.Model.AcceptAPiModel;
import com.example.myofficeproject.Model.AcceptResponseModel;
import com.example.myofficeproject.Model.DeliveryDashboardResponseModel;
import com.example.myofficeproject.Model.assignmentList;
import com.example.myofficeproject.Remote.ApiClient;
import com.example.myofficeproject.Remote.ApiInterface;
import com.example.myofficeproject.Remote.Common;
import com.example.myofficeproject.databinding.DasbordAdapterRowBinding;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DasbordAdapter extends RecyclerView.Adapter<DasbordAdapter.ViewHolder> {

    Context context;
    DeliveryDashboardResponseModel dasbordmodel;
    ArrayList<assignmentList> assignmentLists;

    public DasbordAdapter(Context context, ArrayList<assignmentList>assignmentLists) {
        this.context=context;
        this.assignmentLists=assignmentLists;


    }

    @Override
    public DasbordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(DasbordAdapterRowBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        assignmentList assignment= assignmentLists.get(position);
        holder.binding.tvAssignmentId.setText(String.valueOf(assignment.getAssignmentId()));
        holder.binding.tvAmount.setText(String.valueOf("₹ "+assignment.getAmount()));
        holder.binding.tvCreateDate.setText(Common.formatDate("yyyy-MM-dd'T'HH:mm:ss","dd MMMM yy",assignment.getCreateDate()));
        holder.binding.tvAssignmentStatus.setText(String.valueOf(assignment.getAssignmentStatus()));

        holder.binding.cdvAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<JsonElement> call = apiService.getAcceptAPi(new AcceptAPiModel(assignment.getAssignmentId(),"true",""));

                Log.e("Request=====> ", new Gson().toJson(new AcceptAPiModel(assignment.getAssignmentId(),"true","")));

                call.enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        Log.e("Responce======> ", new Gson().toJson(response.body()));
                        AcceptResponseModel acceptResponseModel = new Gson().fromJson(response.body(), new TypeToken<AcceptResponseModel>() {}.getType());

                        if (response.body()!= null) {
                            holder.binding.tvAccept.setText(acceptResponseModel.getData().getStatus().toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        Log.d("TAG", "Response = " + t.toString());
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        DasbordAdapterRowBinding binding;

        public ViewHolder(DasbordAdapterRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
