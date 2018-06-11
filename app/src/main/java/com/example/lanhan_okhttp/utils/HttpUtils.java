package com.example.lanhan_okhttp.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtils {
    private OkHttpClient okHttpClient;
    //构造方法
    private HttpUtils() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static HttpUtils httpUtils = null;

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public void sendGet(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public void sendPost(String url, RequestBody requestBody, Callback callback) {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
