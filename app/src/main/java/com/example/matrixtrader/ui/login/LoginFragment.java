package com.example.matrixtrader.ui.login;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matrixtrader.R;
import com.example.matrixtrader.core.BaseFragment;
import com.example.matrixtrader.helper.DialogHelper;
import com.example.matrixtrader.helper.SharedPrefsHelper;
import com.example.matrixtrader.helper.ViewHelper;
import com.example.matrixtrader.model.LoginResponseModel;
import com.example.matrixtrader.utils.Constant;

import java.util.HashMap;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private LoginViewModel loginViewModel = new LoginViewModel();
    @BindView(R.id.loginButton) Button loginButton;
    @BindView(R.id.userNameEditText) EditText userNameEditText;
    @BindView(R.id.passwordEditText) EditText passwordEditText;
    private String accountNumber;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new LoginViewModel();
        observeViewModel();
    }

    @Override
    protected void initViewsOnViewCreated(View view) {
        loginButton.setOnClickListener(this);
    }

    private void observeViewModel(){
        loginViewModel.mutableLoginResponse.observe(this,
                new Observer<LoginResponseModel>() {
            @Override
            public void onChanged(LoginResponseModel data) {
                if (data != null) {
                    if (data.getResult().isState()){
                        accountNumber = data.getDefaultAccount();
                        SharedPrefsHelper.saveAccountNo(accountNumber);
                        Bundle bundle = new Bundle();
                        bundle.putString(Constant.ACCOUNT_NUMBER_KEY,accountNumber);
                        navigateTo(R.id.action_fragmentLogin_to_fragmentAccountStatement,bundle);
                    }
                    else {
                        DialogHelper.getInstance().showAlertDialog(data.getResult().getDescription());
                    }
                }
            }
        });

        loginViewModel.error.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("Error","error"+s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        ViewHelper.instance().hideKeyboard();
        HashMap<String,String> params = new HashMap<>();
        params.put("MsgType","A");
        params.put("CustomerNo",String.valueOf(0));
        params.put("Username",userNameEditText.getText().toString().trim());
        params.put("Password",passwordEditText.getText().toString().trim());
        params.put("AccountID",String.valueOf(0));
        params.put("ExchangeID",String.valueOf(4));
        params.put("OutputType",String.valueOf(2));
        loginViewModel.login(params);
    }
}
