package com.example.matrixtrader.helper;

import android.app.ProgressDialog;

import com.example.matrixtrader.R;
import com.example.matrixtrader.core.BaseActivity;

public class DialogHelper {
    private static DialogHelper dialogHelper;
    private ProgressDialog progressDialog;

    public static DialogHelper getInstance(){
        if (dialogHelper == null){
            dialogHelper = new DialogHelper();
        }
        return dialogHelper;
    }

    public void showLoadingDialog(){
        if (progressDialog != null && progressDialog.isShowing()){
            return;
        }
        progressDialog = new ProgressDialog(BaseActivity.currentActivity);
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void hideLoadingDialog(){
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
