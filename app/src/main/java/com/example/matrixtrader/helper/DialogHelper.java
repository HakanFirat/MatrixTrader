package com.example.matrixtrader.helper;

import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import com.example.matrixtrader.R;
import com.example.matrixtrader.core.BaseActivity;

public class DialogHelper {
    private static DialogHelper dialogHelper;
    private AlertDialog loadingDialog;

    public static DialogHelper getInstance(){
        if (dialogHelper == null){
            dialogHelper = new DialogHelper();
        }
        return dialogHelper;
    }

    public void showLoadingDialog(){
        if (loadingDialog != null && loadingDialog.isShowing())
            return;

        AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.currentActivity);
        LayoutInflater inflater = BaseActivity.currentActivity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progress_dialog,null));
        loadingDialog = builder.create();
        loadingDialog.show();
    }

    public void hideLoadingDialog(){
        if (loadingDialog != null && loadingDialog.isShowing()){
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    public void showAlertDialog(String message){
        AlertDialog.Builder dialog = new AlertDialog.Builder(BaseActivity.currentActivity);
        dialog.setTitle(BaseActivity.currentActivity.getString(R.string.warning));
        dialog.setMessage(message);
        dialog.setPositiveButton(BaseActivity.currentActivity.getString(R.string.ok),null);
        dialog.show();
    }
}
