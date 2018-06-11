package com.example.lanhan_okhttp.model;

import okhttp3.Callback;

public abstract class LoginModel {
    public abstract void login(String mUserName, String mPassword, Callback callback);
}
