package com.example.matrixtrader.helper;

public class DisplayHelper {

    private static DisplayHelper displayHelper;

    public static DisplayHelper getInstance(){
        if (displayHelper == null){
            displayHelper = new DisplayHelper();
        }
        return displayHelper;
    }
}
