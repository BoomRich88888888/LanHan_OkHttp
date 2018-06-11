package com.example.lanhan_okhttp.model.impl;

import com.example.lanhan_okhttp.data.Connect;
import com.example.lanhan_okhttp.model.LoginModel;
import com.example.lanhan_okhttp.utils.HttpUtils;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class LoginModelimpl extends LoginModel {
    @Override
    public void login(String mUserName, String mPassword, Callback callback) {
        HttpUtils.getInstance().sendGet(Connect.LOGIN_URL + "?mUserName=" + mUserName + "&mPassword=" + mPassword, callback);
        //POST请求
        RequestBody body = new FormBody.Builder().add("mUserName", mUserName).add("mPassword", mPassword).build();
        HttpUtils.getInstance().sendPost(Connect.LOGIN_URL,body,callback);
    }
}
