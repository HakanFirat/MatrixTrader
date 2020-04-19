package com.example.matrixtrader.network.dataprovider;

import com.example.matrixtrader.model.AccountResponseModel;
import com.example.matrixtrader.model.LoginResponseModel;
import com.example.matrixtrader.network.ApiInterface;
import com.example.matrixtrader.network.ApiRequest;
import com.example.matrixtrader.network.ApiResponseCallback;
import com.example.matrixtrader.network.NetworkService;

import java.util.HashMap;

public class AccountStatementProvider {
    private static final AccountStatementProvider provider = new AccountStatementProvider();
    private static ApiInterface apiInterface = NetworkService.getInstance().getApi();

    public static AccountStatementProvider getInstance(){
        return provider;
    }

    public void accountStatement (HashMap<String,String> requestParams,
                              final ApiResponseCallback<AccountResponseModel> callback){

        ApiRequest<AccountResponseModel> apiRequest = new ApiRequest<>();
        apiRequest.make(apiInterface.accountStatement(requestParams),
                new ApiResponseCallback<AccountResponseModel>() {
            @Override
            public void onComplete(AccountResponseModel response) {
                callback.onComplete(response);
            }

            @Override
            public void onFailure(String message, Integer statusCode) {
                callback.onFailure(message, statusCode);
            }
        });
    }
}
