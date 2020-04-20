package com.example.matrixtrader.helper;

import android.content.SharedPreferences;

import com.example.matrixtrader.core.BaseActivity;
import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefsHelper {

    private static final String SHARED_PREFS_NAME = "matrix";
    private static SharedPreferences sharedPreferences =
            BaseActivity.currentActivity.getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

    private static SharedPreferences.Editor editor = sharedPreferences.edit();
    private static Gson gson = new Gson();

    public static void saveAccountNo(String Id){
        editor.putString("AccountNo",Id);
        editor.apply();
    }

    public static String getAccountNo(){
        String accountNo = sharedPreferences.getString("AccountNo", "");
        return accountNo;
    }
}
