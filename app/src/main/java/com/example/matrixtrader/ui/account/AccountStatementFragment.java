package com.example.matrixtrader.ui.account;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.matrixtrader.R;
import com.example.matrixtrader.core.BaseFragment;
import com.example.matrixtrader.model.AccountResponseModel;
import com.example.matrixtrader.ui.login.LoginViewModel;
import com.example.matrixtrader.utils.Constant;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountStatementFragment extends BaseFragment {

    private String accountNumber;
    private AccountStatementViewModel accountViewModel = new AccountStatementViewModel();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_statement;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            accountNumber = getArguments().getString(Constant.ACCOUNT_NUMBER_KEY);
        }
        //accountStatementViewModel = new AccountStatementViewModel();
        accountViewModel = ViewModelProviders.of(this)
                .get(AccountStatementViewModel.class);
        observeViewModel();
    }

    @Override
    protected void initViewsOnViewCreated(View view) {
        HashMap<String,String> params = new HashMap<>();
        params.put("MsgType","AN");
        params.put("CustomerNo",String.valueOf(0));
        //TODO: Burada Username ve Password gönderilmezse Response'da Item alanı boş geliyor.
        params.put("Username","proje");
        params.put("Password","proje");
        params.put("AccountID",accountNumber);
        params.put("ExchangeID",String.valueOf(4));
        params.put("OutputType",String.valueOf(2));
        accountViewModel.accountStatement(params);
    }

    private void observeViewModel(){
        accountViewModel.mutableAccountResponse.observe(
                this, new Observer<AccountResponseModel>() {
            @Override
            public void onChanged(AccountResponseModel data) {
                Toast.makeText(getContext(), "Sembol: "+data.getItemlist().get(0).getSymbol(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        accountViewModel.error.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("Error","error"+s);
            }
        });
    }
}