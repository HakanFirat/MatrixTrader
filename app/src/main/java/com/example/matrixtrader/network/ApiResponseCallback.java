package com.example.matrixtrader.network;

public interface ApiResponseCallback<T> {
    void onComplete(T response);
    void onFailure(String message, Integer statusCode);
}
