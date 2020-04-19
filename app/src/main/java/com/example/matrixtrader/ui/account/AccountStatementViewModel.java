package com.example.matrixtrader.ui.account;

import androidx.lifecycle.MutableLiveData;

import com.example.matrixtrader.core.BaseViewModel;
import com.example.matrixtrader.helper.DialogHelper;
import com.example.matrixtrader.model.AccountResponseModel;
import com.example.matrixtrader.model.LoginResponseModel;
import com.example.matrixtrader.network.ApiInterface;
import com.example.matrixtrader.network.ApiRequest;
import com.example.matrixtrader.network.ApiResponseCallback;
import com.example.matrixtrader.network.NetworkService;
import com.example.matrixtrader.network.dataprovider.AccountStatementProvider;
import com.example.matrixtrader.network.dataprovider.LoginProvider;

import java.util.HashMap;

public class AccountStatementViewModel extends BaseViewModel {

    public MutableLiveData<AccountResponseModel> mutableAccountResponse = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();

    public void accountStatement(HashMap<String,String> requestParams){
        DialogHelper.getInstance().showLoadingDialog();

        ApiResponseCallback<AccountResponseModel> callback = new ApiResponseCallback<AccountResponseModel>() {
            @Override
            public void onComplete(AccountResponseModel response) {
                mutableAccountResponse.postValue(response);
                DialogHelper.getInstance().hideLoadingDialog();
            }

            @Override
            public void onFailure(String message, Integer statusCode) {
                error.postValue(message);
                DialogHelper.getInstance().hideLoadingDialog();
            }
        };

        AccountStatementProvider.getInstance().accountStatement(requestParams,callback);
    }

    /*private static ApiInterface apiInterface = NetworkService.getInstance().getApi();

    public void accountStatement (HashMap<String,String> requestParams){
        //DialogHelper.getInstance().showLoadingDialog();

        ApiRequest<AccountResponseModel> apiRequest = new ApiRequest<>();
        apiRequest.make(apiInterface.accountStatement(requestParams),
                new ApiResponseCallback<AccountResponseModel>() {
            @Override
            public void onComplete(AccountResponseModel response) {
               mutableAccountResponse.postValue(response);
               //DialogHelper.getInstance().hideLoadingDialog();
            }

            @Override
            public void onFailure(String message, Integer statusCode) {
                error.postValue(message);
                //DialogHelper.getInstance().hideLoadingDialog();
            }
        });

    }*/
}
