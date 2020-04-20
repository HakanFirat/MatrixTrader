package com.example.matrixtrader.helper;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.matrixtrader.core.BaseActivity;

public class ViewHelper {

    private static ViewHelper helper;

    public static ViewHelper instance(){
        if (helper == null){
            helper = new ViewHelper();
        }
        return helper;
    }

    public void hideKeyboard() {
        View view = BaseActivity.currentActivity.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) BaseActivity.currentActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
