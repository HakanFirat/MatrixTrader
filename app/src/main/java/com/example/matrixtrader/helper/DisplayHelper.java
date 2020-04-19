package com.example.matrixtrader.helper;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.example.matrixtrader.R;
import com.example.matrixtrader.core.BaseActivity;

public class DisplayHelper {

    private static DisplayHelper displayHelper;

    public static DisplayHelper getInstance(){
        if (displayHelper == null){
            displayHelper = new DisplayHelper();
        }
        return displayHelper;
    }

    public void changeStatusColor() {
        Window window = BaseActivity.currentActivity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(BaseActivity.currentActivity, R.color.black));
    }
}
