package com.example.demoapp;


import com.example.demoapp.model.User;
import com.example.demoapp.model.UserResponceModel;
import com.example.demoapp.retrofit.ApiClient;
import com.example.demoapp.retrofit.EndPoints;
import com.example.demoapp.room.AppDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private final AppDatabase mDatabase;
    private static DataRepository sInstance;


    private DataRepository(final AppDatabase database) {
        mDatabase = database;
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public void getUserDatafromWeb()
    {
        EndPoints endPoints = ApiClient.getClient().create(EndPoints.class);
        Call<UserResponceModel> call= endPoints.getAllUsers();
        call.enqueue(new Callback<UserResponceModel>() {
            @Override
            public void onResponse(Call<UserResponceModel> call, Response<UserResponceModel> response) {
                if(response.body().getStatusCode() == 200 && response.body().getStatusCode().equals("success"))
                {
                   List<User> users = response.body().getData();

                }
            }

            @Override
            public void onFailure(Call<UserResponceModel> call, Throwable t) {

            }
        });

    }

    private void insertindb(List<? extends User> userList) {

    }

}
