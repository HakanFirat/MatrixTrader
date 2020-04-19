package com.example.matrixtrader.core;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public static BaseActivity currentActivity;
    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        currentActivity = this;
        Log.e("","currentActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        currentActivity = this;
    }

    public void abc(){
        Toast.makeText(currentActivity, "BaseActivity", Toast.LENGTH_SHORT).show();
    }
}
