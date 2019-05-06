package com.example.demoapp.retrofit;

import com.example.demoapp.model.UserResponceModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoints {
    @GET("selectallusers.php")
    Call<UserResponceModel> getAllUsers();
}
