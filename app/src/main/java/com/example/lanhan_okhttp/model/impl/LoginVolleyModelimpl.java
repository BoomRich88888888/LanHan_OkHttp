package com.example.lanhan_okhttp.model.impl;

import com.example.lanhan_okhttp.data.Connect;
import com.example.lanhan_okhttp.model.LoginModel;
import com.example.lanhan_okhttp.utils.HttpUtils;

import okhttp3.Callback;

public class LoginVolleyModelimpl extends LoginModel {
    @Override
    public void login(String mUserName, String mPassword, Callback callback) {
        HttpUtils.getInstance().sendGet(Connect.LOGIN_URL+"?mUserName="+mUserName+"&mPassword="+mPassword,callback);
    }
}
