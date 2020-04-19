package com.example.matrixtrader.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {
    @SerializedName("PositionID")
    private String positionId;
    @SerializedName("AccountID")
    private String accountId;
    @SerializedName("Symbol")
    private String symbol;
    @SerializedName("Qty_T2")
    private Double Qty_T2;
    @SerializedName("LastPx")
    private Double lastPx;

    public String getPositionId() {
        return positionId != null ? positionId : "";
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getAccountId() {
        return accountId != null ? accountId : "";
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSymbol() {
        return symbol != null ? symbol : "";
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getQty_T2() {
        return Qty_T2 != null ? Qty_T2 : 0.0;
    }

    public void setQty_T2(Double qty_T2) {
        Qty_T2 = qty_T2;
    }

    public Double getLastPx() {
        return lastPx != null ? lastPx : 0.0;
    }

    public void setLastPx(Double lastPx) {
        this.lastPx = lastPx;
    }
}
