package com.example.matrixtrader.network.dataprovider;

import com.example.matrixtrader.model.LoginResponseModel;
import com.example.matrixtrader.network.ApiRequest;
import com.example.matrixtrader.network.ApiInterface;
import com.example.matrixtrader.network.ApiResponseCallback;
import com.example.matrixtrader.network.NetworkService;

import java.util.HashMap;

public class LoginProvider {
    private static final LoginProvider loginProvider = new LoginProvider();
    private static ApiInterface apiInterface = NetworkService.getInstance().getApi();

    public static LoginProvider getInstance(){
        return loginProvider;
    }

    public void loginRequest (HashMap<String,String> requestParams,
                              final ApiResponseCallback<LoginResponseModel> callback){

        ApiRequest<LoginResponseModel> apiRequest = new ApiRequest<>();
        apiRequest.make(apiInterface.login(requestParams),
                new ApiResponseCallback<LoginResponseModel>() {
            @Override
            public void onComplete(LoginResponseModel response) {
                callback.onComplete(response);
            }

            @Override
            public void onFailure(String message, Integer statusCode) {
                callback.onFailure(message, statusCode);
            }
        });
    }
}
