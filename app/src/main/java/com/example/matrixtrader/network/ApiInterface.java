package com.example.matrixtrader.network;

import com.example.matrixtrader.model.AccountResponseModel;
import com.example.matrixtrader.model.LoginResponseModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("Integration.aspx")
    Call<LoginResponseModel> login(@QueryMap HashMap<String, String> params);

    @GET("Integration.aspx")
    Call<AccountResponseModel> accountStatement(@QueryMap HashMap<String, String> params);
}
