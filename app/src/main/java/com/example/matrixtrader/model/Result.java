package com.example.matrixtrader.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {
    @SerializedName("State")
    private boolean state;
    @SerializedName("Code")
    private int Code;
    @SerializedName("Description")
    private String description;
    @SerializedName("SessionKey")
    private String sessionKey;
    @SerializedName("Duration")
    private int duration;
    @SerializedName("MsgType")
    private String msgType;
    @SerializedName("Timestamp")
    private boolean timeStamp;
    @SerializedName("ClOrdID")
    private String clOrdID;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSessionKey() {
        return sessionKey != null ? sessionKey : "";
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMsgType() {
        return msgType != null ? msgType : "";
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public boolean isTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(boolean timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getClOrdID() {
        return clOrdID != null ? clOrdID : "";
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }
}
