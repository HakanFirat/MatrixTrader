package com.example.matrixtrader.helper;

import java.text.DecimalFormat;

public class StringHelper {

    private static StringHelper stringHelper;

    public static StringHelper instance(){
        if (stringHelper == null){
            stringHelper = new StringHelper();
        }
        return stringHelper;
    }

    public String amountFormat(Double value){
        DecimalFormat df = new DecimalFormat("###,###,###.###");
        String x = df.format(value);
        if (x.contains(".") && x.contains(",")){
            String[] parse = x.split("\\.");
            return parse[0].replace(",",".") +","+ parse[1];
        } else if (x.contains(".")){
            return x.replace(".",",");
        }
        else {
            return df.format(value).replace(",",".");
        }
    }
}
