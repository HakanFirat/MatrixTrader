package com.example.matrixtrader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.matrixtrader.core.BaseActivity;
import com.example.matrixtrader.model.LoginResponseModel;
import com.example.matrixtrader.ui.login.LoginViewModel;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private LoginViewModel loginViewModel = new LoginViewModel();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        observeViewModel();

        HashMap<String,String> params = new HashMap<>();
        params.put("MsgType","A");
        params.put("CustomerNo",String.valueOf(0));
        params.put("Username","proje");
        params.put("Password","proje");
        params.put("AccountID",String.valueOf(0));
        params.put("ExchangeID",String.valueOf(4));
        params.put("OutputType",String.valueOf(2));
        loginViewModel.login(params);*/
    }

   /* private void observeViewModel(){
        loginViewModel.mutableLoginResponse.observe(this, new Observer<LoginResponseModel>() {
            @Override
            public void onChanged(LoginResponseModel data) {
                if (data != null) {
                    Log.e("Data","data"+data);
                    Toast.makeText(getApplicationContext(),
                            "State"+data.getResult().isState(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginViewModel.error.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("Error","error"+s);
            }
        });
    }*/
}
