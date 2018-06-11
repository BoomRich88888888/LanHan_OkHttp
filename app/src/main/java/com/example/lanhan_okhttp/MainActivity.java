package com.example.lanhan_okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUserName;
    private EditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mUserName = (EditText) findViewById(R.id.mUserName);
        mPassword = (EditText) findViewById(R.id.mPassword);
        mLogin = (Button) findViewById(R.id.mLogin);

        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mLogin:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String mUserNameString = mUserName.getText().toString().trim();
        if (TextUtils.isEmpty(mUserNameString)) {
            Toast.makeText(this, "mUserNameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String mPasswordString = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(mPasswordString)) {
            Toast.makeText(this, "mPasswordString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //原生需求非MVC
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("?mUserNameString="+mUserNameString+"&mPasswordString="+mPasswordString).get().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mLogin.setText("登录失败！");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mLogin.setText("登录成功！");
            }
        });
    }
}
