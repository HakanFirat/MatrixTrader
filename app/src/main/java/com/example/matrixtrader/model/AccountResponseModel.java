package com.example.matrixtrader.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountResponseModel implements Serializable {
    @SerializedName("Result")
    private Result result;
    @SerializedName("Item")
    private ArrayList<Item> itemlist = new ArrayList<>();

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<Item> itemlist) {
        this.itemlist = itemlist;
    }
}
