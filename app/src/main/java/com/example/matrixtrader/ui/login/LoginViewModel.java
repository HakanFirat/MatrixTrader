package com.example.matrixtrader.ui.login;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.matrixtrader.core.BaseViewModel;
import com.example.matrixtrader.helper.DialogHelper;
import com.example.matrixtrader.model.LoginResponseModel;
import com.example.matrixtrader.network.ApiResponseCallback;
import com.example.matrixtrader.network.dataprovider.LoginProvider;

import java.util.HashMap;

public class LoginViewModel extends BaseViewModel {

    public MutableLiveData<LoginResponseModel> mutableLoginResponse = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();

    public void login(HashMap<String,String> requestParams){
        DialogHelper.getInstance().showLoadingDialog();

        ApiResponseCallback<LoginResponseModel> callback = new ApiResponseCallback<LoginResponseModel>() {
            @Override
            public void onComplete(LoginResponseModel response) {
                mutableLoginResponse.postValue(response);
                DialogHelper.getInstance().hideLoadingDialog();
            }

            @Override
            public void onFailure(String message, Integer statusCode) {
                error.postValue(message);
                DialogHelper.getInstance().hideLoadingDialog();
            }
        };

        LoginProvider.getInstance().loginRequest(requestParams,callback);
    }

}
