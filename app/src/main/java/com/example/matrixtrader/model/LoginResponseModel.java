package com.example.matrixtrader.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginResponseModel implements Serializable {

    @SerializedName("Result")
    private Result result;
    @SerializedName("AccountList")
    private ArrayList<String> accountList = new ArrayList<>();
    @SerializedName("DefaultAccount")
    private String defaultAccount;
    @SerializedName("CustomerID")
    private String customerId;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ArrayList<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<String> accountList) {
        this.accountList = accountList;
    }

    public String getDefaultAccount() {
        return defaultAccount != null ? defaultAccount : "";
    }

    public void setDefaultAccount(String defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public String getCustomerId() {
        return customerId != null ? customerId : "";
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
