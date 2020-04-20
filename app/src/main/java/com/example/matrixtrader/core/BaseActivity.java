package com.example.matrixtrader.core;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.matrixtrader.helper.DisplayHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    public static BaseActivity currentActivity;
    private Unbinder mUnbinder;
    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        currentActivity = this;
        DisplayHelper.getInstance().changeStatusColor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        currentActivity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }
}
